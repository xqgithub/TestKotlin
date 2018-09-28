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
}
