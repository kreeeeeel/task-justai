# Тестовое задание - JustAI

## Зависимости:
```
Spring
Spring-Webflux
Retrofit2
```

## Запуск
Для запуска нужно указать переменные окружения

### IDE
В параметрах запуска IDE можно указать в `Run - Edit Configurations - Environment Variables`
Либо же использовать плагин поддерживающий работу `Env`

### Обязательные параметры:
```
1) URL
2) VERSION
3) TOKEN
4) GROUP_ID
5) CONFIRMATION_CODE
```

### Ngrok
Для запуска используется `Ngrok`, для проксирования запросов

#### Установка:
1) Скачиваем `Ngrok`
2) Регистрируем аккаунт
3) Указываем в настройках через `cmd` токен указанный на сайте
4) Запускаем `jar` или через `IDE`
5) Выполняем команду `ngrok http 8080`

### Настройка в ВК

Для настройки бота в Вконтакте, нужно создать `Сообщество`, после в настройках включить сообщения, и перейти в настройки API `Настройки - Работа API`.
Создаем токен, после переходим в раздел `Callback API`, копируем строку которую мы должны вернуть при подтверждении, и вставляем прокси-ссылку `Ngrok` в поле Адрес.
После нажимаем `Подтвердить` и ожидаем запрос от вк

### Запуск Docker

Для запуска докера нужно указать в `ngrok.yml` токен Ngrok и выполнить команду `docker-compose up`
После он запустит `Spring приложение` а затем уже `Ngrok`

В контейнере `Ngrok` найти прокси-урл и использовать в своим целях

#### Получение URL


### Заключение
После успешно выполнения всех пунктов, мы можем пользоваться приложением.

### Контакты
[Telegram](https://t.me/kreeeeeel)