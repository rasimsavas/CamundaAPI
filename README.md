# CamundaAPI

### 1)    CamundaDOTNET: 
Java tarafindan Engine ile elde ettigimiz bazi datalari dotnet tarafina aktarip database vb gibi sorgulamalari veya log kayitlarini tasiyoruz..

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

### 2)    EmbededEngineBpmRun: 
Burada tek Process Engine ile çalışabiliyoruz ve sunucu ile değil basitçe eclipse üzerinden ayağı kalkıyor. Process tanımlayıp Modeler üzerinden deploy ediyoruz. 
          Herhangi bir Engine Configurasyonu yapmak istersek java classları içerisinden gerekli sınıflar aracılığı ile yapabiliyoruz. Her hangi bir xml dosyası ile erişemiyoruz.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

### 3)    TomcatPA: 
Tomcat ile yayınlayacağımız bir Process Aplication (Modeler ile tasarlanıp daha sonra Java Classlarını Bind Ediyoruz) içerisinde JavaDelegateleri ve Modelerda hazırladığımız
          .Bpmn .Form dosyalarını saklar. Ayrıca Modeler ile tasarlanan .Bpmn dosyalarının gerekli ayarları ( örn: ilgili process e erişecek engine veya hangi formları kullanacak gibi )
          META-INF/"processes.xml" dosyasında ayarlanır.
          
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------          
### 4)    TomcatPluginJar: 

Tomcat ile yayınladığımız Process Engine için "bpm-platformçxml" ile gerekli olan ayarları yapacağımız dosya. Bu dosyada Process Enginlerimizi ve her Engine için gerekli ayarları yapabiliyoruz.
Engine Executer gibi bazı alanlara sahiptir. Webapps klasörü (5) altında ise yukarıdaki Process Aplication (3) uygulamamızı "war" dosyası olarak deploy ediyoruz.
Engine "ServletProcessApplication" den implement olan uygulamaları Process olarak ekliyor. bu sayede global olarak process ile alakalı değişkenlere vs erişebiliyoruz.
Cockpit ile görüntüleyebiliyor execute edebiliyoruz.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

### 5) TomcatDeployment: 

Tomcat ile Webapp klasörü altında defaul olarak bir kaç uygulama ekli geliyor. Burada yine default olarak Engine'in kullandığı H2 database gibi bir kaç yararlı uygulamayı deploy ederek geliyor..
Yukarıdaki TomcatPA uygulamamızı webbapp klasörüne war dosyası olarak ekliyoruz. bu war dosyası bizim için her hangi bir process i temsil ediyor. 
bpm-platform.xml dosyasında ise (Server/conf/bpm-platform.xml) Engine için veya Job Executer için gerekli yapılandırmaları yapıyoruz.


