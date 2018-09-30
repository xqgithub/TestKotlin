import java.io.IOException;

import example.com.testkotlin.haha.activity.DataClassActivity;
import example.com.testkotlin.haha.activity.KotlinFromJavaActivity;
import utils.LogUtils;

/**
 * Created by beijixiong on 2018/9/28.
 * java 代码汇总，方便和kotlin进行互调用
 */

public class JavaAlternately {

    /**
     * 返回值为空
     */
    public static void vid() {

    }

    public void removeIndices(int[] indices) {
        if (indices != null) {
            LogUtils.i("indices----->" + indices.length);
        }
    }

    public void removeIndices2(int... indices) {
        if (indices != null) {
            LogUtils.i("indices----->" + indices.length);
        }
    }


    public void test_kotlinfromjava1() {
        int testaa = KotlinFromJavaActivity.testa;//testa 字段是 public static final
        KotlinFromJavaActivity.testb = new DataClassActivity.Person("jack", 7);// testb 字段是 public static 非final
        int testcc = KotlinFromJavaActivity.testc;


        // Java
        KotlinFromJavaActivity.foo(); // OK,静态方法
//        KotlinFromJavaActivity.bar(); // 错误,不是静态方法
        KotlinFromJavaActivity.Companion.foo(); // OK,实例方法
        KotlinFromJavaActivity.Companion.bar(); // OK,实例方法
    }

    public void test_kotlinfromjava3() {
        KotlinFromJavaActivity activity = new KotlinFromJavaActivity();
        String a = "a";
        int b = 1;
        String c = "c";
        activity.test_KotlinFromJava3(a, b, c);
        activity.test_KotlinFromJava3(a, b);
        activity.test_KotlinFromJava3(a);
    }

    public void test_kotlinfromjava4() throws IOException {
        KotlinFromJavaActivity activity = new KotlinFromJavaActivity();
        activity.test_KotlinFromJava4();
    }


}
