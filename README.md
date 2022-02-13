# Проект по автоматизации тестирования для Veeam
<a target="_blank" href="https://www.veeam.com/ru/">Веб сайт Veeam</a>

## :pushpin: Содержание:

- [Технологии и инструменты](#earth_africa-технологии-и-инструменты)
- [Реализованные проверки](#earth_africa-Реализованные-проверки)
- [Сборка в Jenkins](#earth_africa-Jenkins-job)
- [Запуск из терминала](#earth_africa-Запуск-тестов-из-терминала)
- [Allure отчет](#earth_africa-Allure-отчет)
- [Отчет в Telegram](#earth_africa-Уведомление-в-Telegram-при-помощи-бота)
- [Видео примеры прохождения тестов](#earth_africa-Примеры-видео-о-прохождении-тестов)

## :rocket: Технологии и инструменты

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Idea.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="images/logo/GitHub.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="images/logo/Junit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
</p>

## :scroll: Реализованные проверки

- ✓ Поиск вакансии QA Automation.
- ✓ Открытие статьи о Biocad и Exchange (параметризованные тесты).
- ✓ Поиск информации о компании Biocad в скачанном PDF файле.
- ✓ Смена языка с русского на английский.
- ✓ Заполнение Запроса в отдел продаж.

## <img src="images/logo/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a> Jenkins job
<a target="_blank" href="https://jenkins.autotests.cloud/job/10_DikayaAV_unit13/">Сборка в Jenkins</a>
<p align="center">
<a href="https://jenkins.autotests.cloud/job/10_DikayaAV_unit13/"><img src="images/screens/Screenshot_522.png" alt="Jenkins"/></a>
</p>

### Параметры сборки в Jenkins:

- browser (браузер, по умолчанию chrome)
- browserVersion (версия браузера, по умолчанию 91.0)
- browserSize (размер окна браузера, по умолчанию 1920x1080)
- remoteDriverUrl (логин, пароль и адрес удаленного сервера selenoid)
- videoStorage (адрес, по которому можно получить видео)
- threads (количество потоков)

## :computer: Запуск тестов из терминала

Локальный запуск:
```bash
gradle clean test
```

Удаленный запуск:
```bash
clean
test
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-DbrowserMobileView="${BROWSER_MOBILE}"
-DremoteDriverUrl=https://${LOGIN}:${PASSWORD}@${REMOTE_DRIVER_URL}/wd/hub/
-DvideoStorage=https://${REMOTE_DRIVER_URL}/video/
-Dthreads=${THREADS}
```

## <img src="images/logo/Allure.svg" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/10_DikayaAV_unit13/allure/">Allure report</a>

### Основное окно

<p align="center">
<img title="Allure Overview Dashboard" src="images/screens/Screenshot_523.png">
</p>

### Тесты

<p align="center">
<img title="Allure Tests" src="images/screens/Screenshot_524.png">
</p>

### Гафики

<p align="center">
<img title="Allure Graphics" src="images/screens/Screenshot_525.png">
</p>

## <img src="images/logo/Telegram.svg" width="25" height="25"  alt="Allure"/></a> Уведомление в Telegram при помощи бота

<p align="center">
<img title="Allure Overview Dashboard" src="images/screens/Screenshot_528.png">
</p>


### <img src="images/logo/Selenoid.svg" width="25" height="25"  alt="Allure"/></a> Примеры видео о прохождении тестов

<p align="center">
<img title="Selenoid Video" src="images/gif/видео.gif" width="250" height="153"  alt="video"> 
</p>
