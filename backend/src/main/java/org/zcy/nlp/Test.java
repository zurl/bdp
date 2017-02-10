package org.zcy.nlp;

import org.ansj.splitWord.analysis.ToAnalysis;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import weka.classifiers.functions.LibSVM;
import libsvm.svm;
import libsvm.svm_node;
import libsvm.svm_parameter;
import libsvm.svm_problem;

import java.io.File;

/**
 * Created by zcy on 2017/2/10.
 */
public class Test {
    public static void main(String[] args){
        File file = new File("/tmp/ret.xml");
        SAXReader saxReader = new SAXReader();
        try {
            Document doc = saxReader.read(file);
            Element root = doc.getRootElement();

        }catch (Exception e){
            e.printStackTrace();
        }
        //String str = "欢迎使用ansj_seg,(ansj中文分词)在这里如果你遇到什么问题都可以联系我.我一定尽我所能.帮助大家.ansj_seg更快,更准,更自由!" ;
        //System.out.println(ToAnalysis.parse(str));
        //svm_problem svmProblem = new svm_problem();
        //.svmProblem

    }
}
