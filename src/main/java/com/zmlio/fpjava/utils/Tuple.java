package com.zmlio.fpjava.utils;


public abstract class Tuple {

    public static <A, B> Tuple2<A, B> tuple2(A a, B b) {
        return new Tuple2<>(a, b);
    }

    public static <A, B, C> Tuple3<A, B, C> tuple3(A a, B b, C c) {
        return new Tuple3<>(a, b, c);
    }

    public static <A, B, C, D> Tuple4<A, B, C, D> tuple4(A a, B b, C c, D d) {
        return new Tuple4<>(a, b, c, d);
    }

    public static class Tuple2<A, B> extends Tuple {
        public final A _1;
        public final B _2;

        private Tuple2(A _1, B _2) {
            this._1 = _1;
            this._2 = _2;
        }
    }

    public static class Tuple3<A, B, C> extends Tuple {
        public final A _1;
        public final B _2;
        public final C _3;

        private Tuple3(A _1, B _2, C _3) {
            this._1 = _1;
            this._2 = _2;
            this._3 = _3;
        }
    }

    public static class Tuple4<A, B, C, D> extends Tuple {
        public final A _1;
        public final B _2;
        public final C _3;
        public final D _4;

        public Tuple4(A _1, B _2, C _3, D _4) {
            this._1 = _1;
            this._2 = _2;
            this._3 = _3;
            this._4 = _4;
        }
    }
}
