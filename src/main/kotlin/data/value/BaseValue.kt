package data.value

/**
 * 値を保持するValueContainerのwrapper
 *
 * @param <E> 値によってwrapされる要素の種類
 *
 * @author Sponge
 */
interface BaseValue<E> {
    /**
     * 保持している値を返す。通常は保持している値はセットされており、デフォルト値ではない。
     * 値がセットされていないか、{@link #exists()}がfalseを返した際には、
     * {@link #getDefault()}で返されるデフォルト値が返される。
     *
     * @return 保持している値
     */
    fun get() : E

    /**
     * 値が存在しているかどうか(セットされているかどうか)を調べる。
     *
     * @return 値が存在する・セットされているときtrue
     */
    fun exists() : Boolean

    /**
     * デフォルト値を取得する。デフォルト値は常に存在するが、特定の状況下では使用可能性は疑わしい(=使わないとこもある)
     *
     * @return デフォルト値
     */
    fun getDefault() : E

    /**
     * 値を直接取得する。様々な理由により、欠けている値もあるので、
     * {@link #get()}は必要な時(=値が存在しないか、セットされていない時)には、{@link #getDefault}を返す。
     *
     * @return 利用可能であるとき、直接(素)の値
     * (注:つまり値が存在しないか、セットされていないときは{@link #get()}とは異なり、nullが返される
     */
    fun getDirect() : E?

    /**
     * この{@link BaseValue}に関連付けられたKeyを返します
     *
     * @return この値に関連づけられたKey
     */
    fun <T : BaseValue<E>> getKey() : Key<T>
}
