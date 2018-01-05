package example.com.testkotlin.haha.test

/**
 * 00001
 * Created by XQ on 2018/1/5.
 */
class TestUnrelated(o: TestOuter) {
    // o.a, o.b are not visible
    // o.c and o.d are visible (same module)
    // Outer.Nested is not visible, and Nested::e is not visible either
}