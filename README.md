# Kafka and Spring Actuator

## Цифровая академия T1
### Demo проект по использованию популярного брокера сообщений Apache Kafka и библиотеки Spring Boot Actuator

Приложение содержит два модуля:<br/> metric_producer - получает метрики работы приложения и с помощью 
Kafka отправляет их в топик "health-topic".<br/>
metric_consumer - прослушивает сообщения в топике "health-topic" и сохраняет полученные данные в базу данных.<br/>
Возможности Apache Kafka гораздо шире чем представленны в приложении и достойны вашего внимания т.к. Kafka уже является неотъемлимой частью современной разработки! 

### Стек технологий:

+ Java 17;
+ Maven;
+ Spring boot 3;
+ Spring Data;
+ Liquibase;
+ Docker;
+ Lombok;
+ Postgres;
+ Scheduled

### Запуск приложения:
<p>1. Клонируем проект "git clone https://github.com/boris86msk/system_monitoring"</p>
<p>2. Запускаем Docker-контейнер docker compose up -d.
(запускаются Zookeeper, Kafka, поднимается PostgreSQL)</p>
<p>3. Для сборки проекта в корне проекта выполняем команду "mvn install".</p>
<p>4. Запуска приложения "java -jar target/system_monitoring-0.0.1-SNAPSHOT.jar".</p>

### Взаимодействие с приложением:
<p>Микросервис metric_producer работает автономно на http://localhost:8078/ Scheduled настроен на отправку сообщений 1 раз в минуту.</p> 
<p>Микросервис metric_consumer доступен на http://localhost:8077/ и имеет следующие endpoints:<br/>
GET /metrics - полный список сохраненых метрик.<br/>
GET /metrics/{id} - получить метрику по id.<br/>
</p>
<p>Spring Actuator предоставляет множество других отслеживаемых метрик приложения, ознакомиться с ними можно ниже</p>




### Spring Actuator Endpoints:
**auditevents** - _Предоставляет информацию о событиях
аудита для текущего приложения._<br />
**beans** -	_Отображает полный список всех
Spring-бинов в приложении._<br />
**caches** -	_Информация о кэше._<br />
**conditions** -	_Показывает условия, которые
были вычислены для классов конфигурации
и автоконфигурации._<br />
**configprops** -	_Отображает список всех
@ConfigurationProperties_<br />
**env** -	_Отображает свойства из
ConfigurableEnvironment._<br />
**flyway** -	_Показывает миграции баз данных
Flyway, которые были применены._<br />
**health** -	_Показывает сведения о работоспособности
приложения._<br />
**httptrace** -	_Отображает информацию трассировки
HTTP (по умолчанию последние 100 HTTP
запросов-ответов)._<br />
**info** -	_Отображает дополнительную информацию
о приложении._<br />
**integrationgraph** -	_Граф Spring Integration._<br />
**loggers** -	_Отображает и позволяет
изменить конфигурацию логгеров в
приложении._<br />
**liquibase** -	_Показывает примененные миграции
базы данных Liquibase._<br />
**metrics** -	_Показывает информацию о метриках
для текущего приложения._<br />
**mappings** - _Отображает список всех путей
@RequestMapping._<br />
**scheduledtasks** -	_Отображает запланированные задачи
(scheduled tasks)._<br />
**shutdown** -	_Позволяет приложению корректно
завершить работу._<br />
**threaddump** -	_Отображает информацию о потоках._<br />



### Applications properties:

health и info - единственные endpoints, доступные через http по умолчанию.
**Доступ ко всем endpoints<b>**<br />
_ management.endpoints.web.exposure.include=* _<br />
**Доступ ко всем endpoints, кроме некоторых<b>**<br />
_management.endpoints.web.exposure.include=\*_<br />
_management.endpoints.web.exposure.exclude=env_<br />
**Доступ к конкретным endpoints**<br />
_management.endpoints.web.exposure.include=health,info,env_<br />
**Отключение всех endpoints HTTP**<br />
_management.server.port=-1_<br />

**Настройка URL для доступа к endpoints**
По умолчанию все конечные точки доступны по URL /actuator по адресам вида /actuator/{id}.
Однако можно изменить базовый путь /actuator, (на пример на "monitor") используя следующее свойство:<br />
_management.endpoints.web.base-path=/monitor_


