package data.key

import data.value.BaseValue

/**
 * {@link ValueContainer}から値を取得できるように、{@link BaseValue}に対するKey(鍵)を表す。
 * 同様に、{@link Key}は推奨される{@link DataQuery}を取得させる為に、{@link #getQuery}を含み、
 * {@link DataSerializable}の為に使用されうる。
 *
 * @param <V> {@link BaseValue}の型の種類
 *
 * @author Sponge
 */
interface Key<V : BaseValue<*>> : CatalogType {
    /*
    static Builder<?, ?> builder() {
        return
    }
    */

    interface Builder<E, V extends BaseValue<E>> extends ResettableBuilder<Key<V>, Builder<E, V>> {
        /**
         * {@link Key#builder()}が呼び出されたすぐ後に使われる、ビルダーのスターターメソッド。
         * このメソットは、ビルダー自体が適切に生成された{@link Key}を提供するジェネリックを定義する。
         *
         * 主な {@link TypeToken TypeTokens}は{@link TypeTokens}で定義されている。もし、新しいTypeTokenを作成したら、
         * Guavaのwiki(<a href="https://github.com/google/guava/wiki/ReflectionExplained#introduction">ここ</a>)
         * で推奨されているように、tokenの匿名クラスのインスタンスを生成することを推奨する。
         *
         * @param token type token (なるべく匿名で)
         * @param <T> Keyの要素型
         * @param <B> Keyの値の型
         * @return ジェネリック化したこのビルダー
         */
        <T, B extends BaseValue<T>> Builder<T, B> type(TypeToken<B> token);

        /**
         * {@link CatalogType#getId()}で使用されるString型のidをセットする。
         * これは適切にフォーマットされるべきである。フォーマットされたidの例は{@link CatalogType}の説明に記載してある。
         *
         * @param id String型のid
         * @return
         */
        Builder<E, V> id(String id);

        /**
         * 生成された{@link Key}に可読名称をセットする。
         *
         * @param name 可読名称
         * @return このビルダー(チェーン)
         */
        Builder<E, V> name(String name);

        /**
         * {@link DataContainer}と共に使用する為に推奨される{@link DataQuery}をセットする。
         *
         * @param query DataQuery
         * @return このビルダー(チェーン)
         */
        Builder<E, V> query(DataQuery query);

        /**
         * {@link #type(TypeToken)}. {@link #id(String)},
         * {@link #name(String)}, {@link #query(DataQuery)}
         * が提供されていれば、新しい{@link Key}を生成する。
         *
         * @return 生成されたKey
         */
        Key<V> build();

        @Override
        @Deprecated
        default Builder<E, V> from(Key<V> value) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("重複したKeyを作成することはできません。");
    }
    }
}
