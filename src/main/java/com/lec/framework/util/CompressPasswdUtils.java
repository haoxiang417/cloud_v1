package com.lec.framework.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.ZipInputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.unzip.UnzipUtil;
import net.lingala.zip4j.util.Zip4jConstants;

/*******************************************************************************
 * -------------------------------------------------------------------------------
 * 本类的作用是将目标文件夹 压缩成ZIP文件,并支持对文件的加密
 ******************************************************************************/
public class CompressPasswdUtils {


  private ZipFile zipFile;
  private String key;

  public CompressPasswdUtils(String pathName, String key) {
    try {
      zipFile = new ZipFile(pathName);
      this.key = key;
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 压缩文件
   */
  public void compress(String targetPathName) {
    File file = new File(targetPathName);
    if (!file.exists()) {
      throw new RuntimeException(targetPathName + "不存在！");
    }
    try {
      //设置压缩文件参数
      ZipParameters parameters = new ZipParameters();
      //设置压缩方法
      parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
      //设置压缩级别
      //DEFLATE_LEVEL_FASTEST     - Lowest compression level but higher speed of compression
      //DEFLATE_LEVEL_FAST        - Low compression level but higher speed of compression
      //DEFLATE_LEVEL_NORMAL  - Optimal balance between compression level/speed
      //DEFLATE_LEVEL_MAXIMUM     - High compression level with a compromise of speed
      //DEFLATE_LEVEL_ULTRA       - Highest compression level but low speed
      parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
      //设置压缩文件加密
      parameters.setEncryptFiles(true);
      //设置加密方法
      parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
      //设置aes加密强度
      parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
      //设置密码
      parameters.setPassword(this.key);
      compress(new File(targetPathName), parameters);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private void compress(File file, ZipParameters zipParameters) {
    /* 判断是目录还是文件 */
    if (file.isDirectory()) {
      this.compressDirectory(file, zipParameters);
    } else {
      this.compressFile(file, zipParameters);
    }
  }

  /**
   * 压缩一个目录
   */
  private void compressDirectory(File dir, ZipParameters zipParameters) {
    if (!dir.exists()) {
      return;
    }
    File[] files = dir.listFiles();
    for (int i = 0; i < files.length; i++) {
      /* 递归 */
      compress(files[i], zipParameters);
    }
  }

  /**
   * 压缩一个文件
   */
  private void compressFile(File file, ZipParameters zipParameters) {
    if (!file.exists()) {
      return;
    }
    try {
      zipFile.addFile(file, zipParameters);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void extract(String dir) throws ZipException, IOException {
    if (zipFile.isEncrypted()) {
      zipFile.setPassword(key);
    }
    List fileHeaderList = zipFile.getFileHeaders();

    for (int i = 0; i < fileHeaderList.size(); i++) {
      FileHeader fileHeader = (FileHeader) fileHeaderList.get(i);
      if (fileHeader != null) {
        File outFile = new File(dir, fileHeader.getFileName());
        if (fileHeader.isDirectory()) {
          outFile.mkdirs();
          continue;
        }

        File parentDir = outFile.getParentFile();
        if (!parentDir.exists()) {
          parentDir.mkdirs();
        }

        ZipInputStream is = zipFile.getInputStream(fileHeader);
        OutputStream os = new FileOutputStream(outFile);

        int readLen = -1;
        byte[] buff = new byte[4096];

        while ((readLen = is.read(buff)) != -1) {
          os.write(buff, 0, readLen);
        }
        os.close();
        os = null;
        is.close();
        is = null;
        UnzipUtil.applyFileAttributes(fileHeader, outFile);
      } else {
        System.err.println("fileheader is null. Shouldn't be here");
      }
    }
  }

  public static void main(String[] args) {
    CompressPasswdUtils zc = new CompressPasswdUtils("d:\\aa.zip", "wxm");
    try {
      zc.extract("D:\\aa"); // 压缩一个文件夹
    } catch (ZipException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
