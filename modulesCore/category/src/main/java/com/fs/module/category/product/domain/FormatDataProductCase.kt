package com.fs.module.category.product.domain

import com.fs.libbase.netbase.BaseUseCase
import com.fs.module.category.product.data.ProductDetailRepository
import javax.inject.Inject

/**
 * 网域层负责封装复杂的业务逻辑，或者由多个 ViewModel 重复使用的简单业务逻辑。此层是可选的，因为并非所有应用都有这类需求。因此，您应仅在需要时使用该层，例如处理复杂逻辑或支持可重用性。

网域层具有以下优势：
避免代码重复。
改善使用网域层类的类的可读性。
改善应用的可测试性。
让您能够划分好职责，从而避免出现大型类。
 */
class FormatDataProductCase @Inject constructor(
    private val productDetailRepository: ProductDetailRepository
) : BaseUseCase() {


}