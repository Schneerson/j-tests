package Constats;

public interface Common {
    String BUY_NOW_BUTTON_PATH = "//button[@class='button___QgjBY rounded-rect___SFxsn large___-7jyU accent___iYF8E large___-7jyU']";
    String CART_BUTTON_XPATH = "//button[@class='button___QgjBY rounded-rect___SFxsn large___-7jyU gray___3JeHp large___-7jyU']";
    String MORE_VARIANTS_FOR_AUTHORIZATION_BUTTON_PATH = "//*[@class='button___1YtF2 size-normal theme-default___Eq4qM']";
    String PRODUCT_WITHOUT_SELECTABLE_OPTIONS_PAGE_URL = "https://www.joom.com/ru/products/604f1de51436ae0106cbb7f2";
    String PRODUCT_NAME_XPATH = "//h1[@class = 'name___3sZiF']";
    String PRODUCT_WITH_SELECTABLE_OPTIONS_PAGE_URL = "https://www.joom.com/ru/products/619752c9785b80012dd73ddd";
    String PRODUCT_PAGE_URL = "https://www.joom.com/ru/products/60bf2442f15fc301a69d8859";
    String AUTHORIZATION_WITH_EMAIL_BUTTON_PATH =  "//*[@class='button___1YtF2 email___3-nIG size-normal']";
    String OPTION_COLOUR_BUTTON_XPATH = "//*[@class='border___11f1x']";
    String OPTION_SIZE_BUTTON_XPATH = "//*[@class='border___2Hn4H']";
    String AUTHORIZATION_BUTTON_PATH =  "//*[@class='link___RMIFj button___1Naxi']";
    String GET_LINK_BUTTON_PATH = "//*[@class='label___3R7yr']";
    String FAVORITE_BUTTON_PATH = "//*[@class='favoriteButton___2Yxao favorite']";
    String PRODUCT_ADDED_TO_CART_ALERT_BUTTON = "//*[@class='inner___68AzF']";
    String NOT_CHOOSING_COLOUR_OPTION_ALERT_XPATH = "//*[@class='title___39_yt']";
    String NOT_CHOOSING_SIZE_OPTION_ALERT_XPATH = "//*[@class='title___1mko2']";
    String LINK_ON_PRODUCT_PATH = "//*[@class='copyContainer___B8ZNs']";
    String ENTER_BUTTON_PATH =  "//*[@class='caption___3L-qE']";
    String CLOSE_ALERT_PATH =  "//*[@class='close___1ba7f']";
    String FAVORITE_BUTTON_XPATH = "//*[@href='/ru/favorites']";
    String NOT_CHOOSING_COLOUR_OPTION_ALERT = "Цвет не выбран";
    String NOT_CHOOSING_SIZE_OPTION_ALERT = "Размер не выбран";
    String PASSWORD_INPUT_PATH = "//*[@name='password']";
    String EMAIL_INPUT_PATH = "//*[@name='email']";
    String PRODUCT_IN_FAVORITE_PATH = "//*[@class='imageWrap___3oDRW']";
    String WITHOUT_WAIT_MODE = "Without waiting";
    String WAIT_MODE = "With waiting";
    String EMAIL = "vvvvvdda@mail.ru";
    String COUNT_OF_PRODUCT_IN_CART_PATH = "//*[@class='count___3LcYb']";
    String PASSWORD = "12345aaa";
    String ADDED_TO_FAVORITE_STATUS = "В избранном";
    String CHROME_ARGUMENTS = "--disable-notifications";
    String PRODUCTS_IN_CART_XPATH = "//*[@class='nameText___3-ogM']";
    String PROFILE_XPATH =
            "//*[@class='image___1yp2c  avatar____C13d image___1yp2c outline___25ytj noBackground___2lkq2 " +
                    "small___2Rb1P empty___2596E']";
    int TIMING_FOR_THREAD_SLEEP = 5000;
    int PRODUCT_COUNT = 1;
}
