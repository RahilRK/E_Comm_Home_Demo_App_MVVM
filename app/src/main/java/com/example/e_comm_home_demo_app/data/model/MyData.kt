package com.example.e_comm_home_demo_app.data.model

data class MyData(
    val ShopByBrands: List<ShopByBrand>,
    val allowAndroidDownload: Boolean,
    val allowIosDownload: Boolean,
    val allowedCurrencies: List<AllowedCurrency>,
    val androidDownloadLink: Any,
    val appButtonColor: String,
    val appLogo: String,
    val appLogoDominantColor: String,
    val appThemeColor: String,
    val appThemeTextColor: String,
    val bannerImages: List<BannerImage>,
    val buttonTextColor: String,
    val carousel: List<Carousel>,
    val categories: List<Category>,
    val clickUrl: String,
    val cmsData: List<CmsData>,
    val darkAppButtonColor: String,
    val darkAppLogo: String,
    val darkAppLogoDominantColor: String,
    val darkAppThemeColor: String,
    val darkAppThemeTextColor: String,
    val darkButtonTextColor: String,
    val darkSplashImage: String,
    val defaultCurrency: String,
    val eTag: String,
    val featuredCategories: List<FeaturedCategory>,
    val iosDownloadLink: Any,
    val launcherIconType: String,
    val magazine_url: String,
    val message: String,
    val prefix_text: String,
    val priceFormat: PriceFormat,
    val showSwatchOnCollection: Boolean,
    val sort_order: List<SortOrder>,
    val splashImage: String,
    val storeData: List<StoreData>,
    val success: Boolean,
    val suffix_text: String,
    val tabCategoryView: String,
    val themeCode: Any,
    val themeType: Int,
    val waiting_text: String,
    val walkthroughVersion: String,
    val websiteData: List<WebsiteData>,
    val wishlistEnable: Boolean
)