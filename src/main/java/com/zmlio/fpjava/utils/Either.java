package com.zmlio.fpjava.utils;

import java.util.Objects;
import java.util.Optional;

public class Either<R, L> {
    private final Optional<L> leftOpt;
    private final Optional<R> rightOpt;

    private final boolean right;

    private Either(L left, R right, boolean isRight) {
        this.leftOpt = Optional.ofNullable(left);
        this.rightOpt = Optional.ofNullable(right);
        this.right = isRight;
    }

    public static <T, S> Either<T, S> right(T right, S left) {
        return new Either<>(left, right, true);
    }

    public static <T, S> Either<T, S> left(T right, S left) {
        return new Either<>(left, right, false);
    }

    public L left() {
        return leftOpt.get();
    }

    public R right() {
        return rightOpt.get();
    }

    public Optional<R> rightOpt() {
        return this.rightOpt;
    }

    public Optional<L> leftOpt() {
        return this.leftOpt;
    }

    public boolean isLeft() {
        return !this.isRight();
    }

    public boolean isRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Either<?, ?> either = (Either<?, ?>) o;
        return right == either.right &&
                leftOpt.equals(either.leftOpt) &&
                rightOpt.equals(either.rightOpt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftOpt, rightOpt, right);
    }
}
