package xyz.trankvila.menteia.tipsistemo

import xyz.trankvila.menteia.vorttrakto.Legilo
import kotlin.reflect.KClass

sealed class vanemis(
        morem: Any? = null,
        ponem: Any? = null,
        forem: Any? = null
): timis(morem, ponem, forem) {
    abstract class tadumis<morum: timis>(
            val _valuo: Boolean,
            val _frazo: morum?,
            ponem: Any? = null,
            forem: Any? = null
    ): vanemis(_frazo, ponem, forem) {
        override suspend fun _valuigi(): Boolean {
            return _valuo
        }
    }

    abstract class fragemis<morum: _bazaTipo>(
            val _valuo: morum,
            morem: Any? = null,
            ponem: Any? = null,
            forem: Any? = null
    ): vanemis(morem, ponem, forem)
}

class to(morem: timis, ponem: _bazaTipo): vanemis.tadumis<timis>(
        morem == ponem,
        morem, ponem
)

class ko<morum: _bazaTipo>(morem: morum): vanemis.fragemis<morum>(
        morem,
        morem
) {
    override suspend fun _valuigi(): Any? {
        return _valuo._valuigi()
    }
}

class klos(morem: vanemis.tadumis<*>): vanemis.tadumis<timis>(
        !morem._valuo,
        morem
)

class tres(morem: timis, ponem: KClass<*>): vanemis.tadumis<timis>(
        ponem.isInstance(morem),
        morem, Legilo._nomoKunTipaktantoj(ponem)
)

class sindis(morem: timis?): vanemis.tadumis<timis>(morem != null, morem)