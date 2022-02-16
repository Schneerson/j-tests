# Тесты для joom

<p> Для запуска тестов следует 
  </p>

  1. Скопировать репозиторий на своё устройство
 2. Открыть его в среде разработки, перейти на ветку refactor/PageObject
 3. Затем тесты можно запустить либо, используя интерфейс среды разработки, либо с помощью Maven командой maven test

# Таблица покрытия

Название теста  | Функциональный блок | Статус
------------- | -------------| -------------
Добавление товара без выбираемых параметров в корзину  | Выбор товаров | Готов
Успешное добавление товара с выбираемыми параметрами в  корзину  | Выбор товаров | Готов
Попытка добавить в корзину товар с выбираемыми параметрами, не выбрав ни одного параметра  | Выбор товаров | Готов
Попытка добавить в корзину товар с выбираемыми параметрами, выбрав только часть параметров  | Выбор товаров | Готов
Заказ товара без выбираемых параметров через кнопку Купить сейчас  | Выбор товаров | Готов 
Успешный заказ товара с выбираемыми параметрами через кнопку Купить сейчас  | Выбор товаров | Готов
Попытка заказа товара с выбираемыми параметрами через кнопку Купить сейчас без выбора всех параметров  | Выбор товаров | Готов
Попытка заказа товара с выбираемыми параметрами через кнопку Купить сейчас без выбора части параметров  | Выбор товаров | Готов
Добавление товара в список Избранное  | Выбор товаров | Готов
Получение ссылки на товар  | Выбор товаров | Готов
После нажатия несколько раз на кнопку “Добавить в корзину” в корзине сохраняется товар только в одном экземпляре  | Выбор товаров | Готов
После нажатия на кнопку “Добавить в корзину” и после на кнопку “Купить сейчас” в корзине сохраняется товар только в одном экземпляре  | Выбор товаров | Готов
После нажатия несколько раз на кнопку “Купить сейчас” в корзине сохраняется товар только в одном экземпляре  | Выбор товаров | Готов
При добавлении в корзину нескольких разных товаров подряд в ней сохраняются все товары  | Выбор товаров | Готов
При добавлении нескольких товаров в корзину при помощи кнопки Купить сейчас в корзине сохраняются все товары  | Выбор товаров | Готов

