package com.lec.common.dictionary.type;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.lec.framework.log.Logging;

/***
 * 数据字典类型xml文件解析器
 * 
 * @since 1.0
 * @author zhouhaij createTime 2013-11-20
 */
public class DicTypeParser {

	private static Document doc;

	protected Logging logger = new Logging(getClass());

	public DicTypeParser() {
		InputStream file = null;
		try {
			file = Thread.currentThread().getContextClassLoader().getResourceAsStream("dic-types.xml");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		SAXReader saxReader = new SAXReader();
		saxReader.setEncoding("UTF-8");
		try {
			doc = saxReader.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/***
	 * 根据分组id获取组下的所有类型
	 * 
	 * @param groupId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<DicTypeNode> getDicTypesByGroupId(String groupId) {
		List<DicTypeNode> nodes = new ArrayList<DicTypeNode>();
		Element el = (Element) doc.selectSingleNode("dics/group[@id='" + groupId + "']");
		if(el==null) return nodes;
		List childs = el.elements();
		DicTypeNode node = null;
		for (Object obj : childs) {
			Element dic = (Element) obj;
			node = new DicTypeNode();
			node.setKey(dic.attributeValue("key"));
			node.setName(dic.attributeValue("name"));
			node.setGencode(dic.attributeValue("gencode"));
			nodes.add(node);
		}
		return nodes;
	}
	
	/***
	 * 根据分组id获取组下的所有类型编码，以逗号分隔
	 * @param groupId
	 * @return
	 */
	public String getTypesByGroupId(String groupId){
		Element el = (Element) doc.selectObject("dics/group[@id='" + groupId + "']");
		StringBuilder sb = new StringBuilder();
		for (Object obj : el.elements()) {
			Element dic = (Element) obj;
			sb.append(dic.attributeValue("key")).append(",");
		}
		return StringUtils.removeEnd(sb.toString(),",");
	}

	public String getNodeByDicKey(String key, String atrribute) {
		Element el = (Element) doc.selectObject("dics/group/dic[@key='" + key + "']");
		return el.attributeValue(atrribute);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DicTypeParser parser = new DicTypeParser();
		List<DicTypeNode> childs = parser.getDicTypesByGroupId("base");
		for (DicTypeNode obj : childs) {
			System.out.println(obj.getKey());
		}
		System.out.println(parser.getTypesByGroupId("base"));

		System.out.println(parser.getNodeByDicKey("dewater", "gencode"));
	}

}
