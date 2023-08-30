package ai.corca.adcio_android_plugins.usecases.mockapp.fragment

import ai.corca.adcio_android_plugins.databinding.FragmentHomeBinding
import ai.corca.adcio_android_plugins.usecases.mockapp.adapter.CategoryAdapter
import ai.corca.adcio_android_plugins.usecases.mockapp.adapter.ProductAdapter
import ai.corca.adcio_android_plugins.usecases.mockapp.adapter.model.Product
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var productAdapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false,
        )
        initView()
        return binding.root
    }

    private fun initView() {
        categoryAdapter = CategoryAdapter()
        binding.rvCategory.adapter = categoryAdapter
        categoryAdapter.submitList(listOf("럭셔리", "뷰티", "스포츠", "아울렛", "키즈", "골프", "어스", "패션톡"))

        productAdapter = ProductAdapter()
        binding.rvProduct.adapter = productAdapter
        productAdapter.submitList(
            listOf(
                Product(productId = "djslfjd", isAd = false, name = "어센틱클래식 후드 화이트 오트밀 STHD3338", image = "https://image.msscdn.net/images/goods_img/20200903/1582356/1582356_1_500.jpg", brand = "티떠블유엔", sale = "10%", price = "60000원"),
                Product(productId = "djslfjd", isAd = false, name = "어센틱클래식 후드 화이트 오트밀 STHD3338", image = "https://image.msscdn.net/images/goods_img/20200903/1582356/1582356_1_500.jpg", brand = "티떠블유엔", sale = "10%", price = "60000원"),
                Product(productId = "djslfjd", isAd = false, name = "어센틱클래식 후드 화이트 오트밀 STHD3338", image = "https://image.msscdn.net/images/goods_img/20200903/1582356/1582356_1_500.jpg", brand = "티떠블유엔", sale = "10%", price = "60000원"),
                Product(productId = "djslfjd", isAd = false, name = "어센틱클래식 후드 화이트 오트밀 STHD3338", image = "https://image.msscdn.net/images/goods_img/20200903/1582356/1582356_1_500.jpg", brand = "티떠블유엔", sale = "10%", price = "60000원"),
                Product(productId = "djslfjd", isAd = false, name = "어센틱클래식 후드 화이트 오트밀 STHD3338", image = "https://image.msscdn.net/images/goods_img/20200903/1582356/1582356_1_500.jpg", brand = "티떠블유엔", sale = "10%", price = "60000원"),
                Product(productId = "djslfjd", isAd = false, name = "어센틱클래식 후드 화이트 오트밀 STHD3338", image = "https://image.msscdn.net/images/goods_img/20200903/1582356/1582356_1_500.jpg", brand = "티떠블유엔", sale = "10%", price = "60000원"),
                Product(productId = "djslfjd", isAd = false, name = "어센틱클래식 후드 화이트 오트밀 STHD3338", image = "https://image.msscdn.net/images/goods_img/20200903/1582356/1582356_1_500.jpg", brand = "티떠블유엔", sale = "10%", price = "60000원"),
                Product(productId = "djslfjd", isAd = false, name = "어센틱클래식 후드 화이트 오트밀 STHD3338", image = "https://image.msscdn.net/images/goods_img/20200903/1582356/1582356_1_500.jpg", brand = "티떠블유엔", sale = "10%", price = "60000원"),
                Product(productId = "djslfjd", isAd = false, name = "어센틱클래식 후드 화이트 오트밀 STHD3338", image = "https://image.msscdn.net/images/goods_img/20200903/1582356/1582356_1_500.jpg", brand = "티떠블유엔", sale = "10%", price = "60000원"),
                Product(productId = "djslfjd", isAd = false, name = "어센틱클래식 후드 화이트 오트밀 STHD3338", image = "https://image.msscdn.net/images/goods_img/20200903/1582356/1582356_1_500.jpg", brand = "티떠블유엔", sale = "10%", price = "60000원"),
                Product(productId = "djslfjd", isAd = false, name = "어센틱클래식 후드 화이트 오트밀 STHD3338", image = "https://image.msscdn.net/images/goods_img/20200903/1582356/1582356_1_500.jpg", brand = "티떠블유엔", sale = "10%", price = "60000원"),
                Product(productId = "djslfjd", isAd = false, name = "어센틱클래식 후드 화이트 오트밀 STHD3338", image = "https://image.msscdn.net/images/goods_img/20200903/1582356/1582356_1_500.jpg", brand = "티떠블유엔", sale = "10%", price = "60000원"),
                Product(productId = "djslfjd", isAd = false, name = "어센틱클래식 후드 화이트 오트밀 STHD3338", image = "https://image.msscdn.net/images/goods_img/20200903/1582356/1582356_1_500.jpg", brand = "티떠블유엔", sale = "10%", price = "60000원"),
                Product(productId = "djslfjd", isAd = false, name = "어센틱클래식 후드 화이트 오트밀 STHD3338", image = "https://image.msscdn.net/images/goods_img/20200903/1582356/1582356_1_500.jpg", brand = "티떠블유엔", sale = "10%", price = "60000원"),
                Product(productId = "djslfjd", isAd = false, name = "어센틱클래식 후드 화이트 오트밀 STHD3338", image = "https://image.msscdn.net/images/goods_img/20200903/1582356/1582356_1_500.jpg", brand = "티떠블유엔", sale = "10%", price = "60000원"),
                Product(productId = "djslfjd", isAd = false, name = "어센틱클래식 후드 화이트 오트밀 STHD3338", image = "https://image.msscdn.net/images/goods_img/20200903/1582356/1582356_1_500.jpg", brand = "티떠블유엔", sale = "10%", price = "60000원"),
            )
        )
    }
}