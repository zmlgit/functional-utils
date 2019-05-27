package com.zmlio.fpjava.utils;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public interface Result<T> {

    int getStatus();

    boolean isSuccess();

    String getMessage();

    Optional<T> getData();

    default T get() {
        return getData().get();
    }

    default boolean isPresent() {
        return getData().isPresent();
    }

    default void ifPresent(Consumer<? super T> consumer) {
        getData().ifPresent(consumer);
    }

    default Optional<T> filter(Predicate<? super T> predicate) {
        return getData().filter(predicate);
    }

    default <U> Optional<U> map(Function<? super T, ? extends U> mapper) {
        return getData().map(mapper);
    }

    default <U> Optional<U> flatMap(Function<? super T, Optional<U>> mapper) {
        return getData().flatMap(mapper);
    }

    default T orElse(T other) {
        return getData().orElse(other);
    }

    default T orElseGet(Supplier<? extends T> other) {
        return getData().orElseGet(other);
    }

    default <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        return getData().orElseThrow(exceptionSupplier);
    }

    static <T> Result<T> success(T data, int status) {
        return new Success<>(data, status, "");
    }

    static <T> Result<T> error(String message, int status) {
        return new Error<>(message, status);
    }

    class Success<T> implements Result<T> {
        private final Optional<T> data;

        private final String message;
        private final int status;

        Success(T data, int status, String message) {
            this.data = Optional.ofNullable(data);
            this.message = message;
            this.status = status;
        }

        @Override
        public int getStatus() {
            return this.status;
        }

        @Override
        public boolean isSuccess() {
            return true;
        }

        @Override
        public String getMessage() {
            return message;
        }

        @Override
        public Optional<T> getData() {
            return data;
        }
    }

    class Error<T> implements Result<T> {
        private final String message;
        private final int status;

        Error(String message, int status) {
            this.message = message;
            this.status = status;
        }

        @Override
        public int getStatus() {
            return this.status;
        }

        @Override
        public boolean isSuccess() {
            return false;
        }

        @Override
        public String getMessage() {
            return this.message;
        }

        @Override
        public Optional<T> getData() {
            return Optional.empty();
        }

    }
}
