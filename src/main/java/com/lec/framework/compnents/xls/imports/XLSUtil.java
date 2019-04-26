package com.lec.framework.compnents.xls.imports;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

/**
 * <p>
 * 标题：Xls工具类
 * </p>
 * @author zhouhaijian
 */
public abstract class XLSUtil {

	/**
	 * 获取单元格的值
	 * 
	 * @param cell
	 * @return
	 */
	public static String getCell(Cell cell) {
		if (cell == null)
			return "";
		switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:
				return getNumberCellValue(cell);
			case Cell.CELL_TYPE_STRING:
				return cell.getStringCellValue();
			case Cell.CELL_TYPE_FORMULA:
				return cell.getCellFormula();
			case Cell.CELL_TYPE_BLANK:
				return "";
			case Cell.CELL_TYPE_BOOLEAN:
				return String.valueOf(cell.getBooleanCellValue());
			case Cell.CELL_TYPE_ERROR:
				return String.valueOf(cell.getErrorCellValue());
			}
		return "";
	}

	private static String getNumberCellValue(Cell cell) {
		cell.setCellType(Cell.CELL_TYPE_STRING);
		return cell.getStringCellValue();
	}



		/**
		 * 获取单元格的值,处理日期值
		 * 
		 * @param cell
		 * @return
		 */
		public static String getCell(Cell cell,String formatStr) {
			if (cell == null)
				return "";
			switch (cell.getCellType()) {
				case Cell.CELL_TYPE_NUMERIC:
					return getNumberCellValue(cell,formatStr);
				case Cell.CELL_TYPE_STRING:
					
					return cell.getStringCellValue();
				case Cell.CELL_TYPE_FORMULA:
					return cell.getCellFormula();
				case Cell.CELL_TYPE_BLANK:
					return "";
				case Cell.CELL_TYPE_BOOLEAN:
					return String.valueOf(cell.getBooleanCellValue());
				case Cell.CELL_TYPE_ERROR:
					return String.valueOf(cell.getErrorCellValue());
				}
			return "";
		}
		
		private static String getNumberCellValue(Cell cell,String formatStr) {
			double dd = cell.getNumericCellValue();
			if (DateUtil.isCellDateFormatted(cell)){
		         java.util.Date date = DateUtil.getJavaDate(dd);
		        return com.lec.framework.util.DateUtil.dateFormatToString(date, formatStr);
			}else{
			return Math.round(dd) + "";
			}
		}
		
	}

