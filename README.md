# Introduccion

La Api support-captcha-v3 es una api de soporte que genera el captcha cifrado de modo aleatorio a partir de una semilla

## Contenido

- [Acerca](#acerca)
- [Uso](#uso)
  - [Instalacion](#instalacion)
  - [Comandos](#comandos)
- [Desarrollo](#desarrollo)
  - [Test](#test)  
  - [Integracion Continua](#integracion-continua)
  - [Despliegue](#despliegue)  
  - [Ramas](#ramas)
  - [Commits](#commits)  
  - [Pull Request](#pull-request)

## Acerca <a name="acerca"></a>

El Microservicio de Support-captcha-v3 permite:
* Generar captcha cifrado de modo aleatorio
* Validar el captcha cifrado

desde una semilla

## Uso <a name="uso"></a>
Siga las siguientes instrucciones para iniciar el desarrollo de este proyecto.

### Instalacion <a name="instalacion"></a>
- Plugins que deben estar instalados en su IDE:
    * Lombok - Libreria de Bytecode que genera automaticamente los Getters y Setters.
    * CheckStyle - Plugin para poder comprobar el estilo del codigo usando las reglas de Google
- Instalar JCE (Java Cryptography Extension)
    * [JCE](https://www.oracle.com/java/technologies/javase-jce8-downloads.html)
- Configure las variables de entorno
    | Variable | Valor |
    |----|------------ |
    | LOGSTASH_SOCKET | pmbklnxd11:9800 |
    | spring.cloud.config.uri | https://ass-config-server-v2.ocpappsdesa.credito.bcp.com.pe/config-server |
    | spring.cloud.config.name | nombre-del-microservicio |
    | spring.cloud.config.username | APTLDES |
    | spring.cloud.config.label | rama-de-propiedades |
    | spring.profiles.active | local |
    | spring.cloud.config.profile | dev |
    | spring.cloud.config.password | password-aqui |
    | server.port | 9093 o el que este disponible |


### Comandos <a name="comandos"></a>
- Para ejecutar las pruebas ejecute lo siguiente
    * Pruebas unitarias
    ```shell
    mvn test
    ```
    * Pruebas de integracion
    ```shell
    mvn verify -Dskip.integration.tests=false -Dskip.unit.tests=true
    ```

## Desarrollo <a name="desarrollo"></a>
Tener en cuenta lo siguiente al momento del desarrollo

### Test <a name="test"></a>

* Uso de Patron AAA
* Convencion de nombre Verbo + SUT + When + Condicional
* Mas buenas practicas puede consultar [Aqui](https://confluence.lima.bcp.com.pe/display/CTTIIDPSPUB/Unit+Testing) 


### Integracion Continua <a name="integracion-continua"></a>

Los pipeline de build y CI se encuentran definidos en los siguientes archivos:

* jenkins/Jenkinsfile-ic-build-pipeline.groovy:<br>
     compila, ejecuta las pruebas unitarias, ejecuta los plugin CheckStyle y FindBugs.
* jenkins/Jenkinsfile-ic-pipeline.groovy:<br> compila, ejecuta las pruebas unitarias, ejecuta los plugin CheckStyle y FindBugs, hace análisis con SonarQube y por último sube la versión SNAPSHOT del proyecto a artifactory.
Para la ejecución del job de build, se debe configurar un webhook para que se ejecute cada vez que se haga un push al proyecto.

La ejecución del job de CI, puede ser a demanda, desde la rama develop.

### Despliegue <a name="despliegue"></a>

Los despliegues se realizan desde Jenkins verificar el delivery branch este actualizada a 2.1 .

Los pipeline para realizar los despliegues se encuentran en los siguientes archivos:

* jenkins/Jenkinsfile-delivery-dev-pipeline.groovy :<br>
 el cual compila, ejecuta las pruebas unitarias, hace análisis con SonarQube, sube la versión SNAPSHOT del proyecto a artifactory y despliega en el ambiente de desarrollo.
* jenkins/Jenkinsfile-delivery-cert-pipeline.groovy: <br> 
el cual crea una nueva rama release/{version} desde la ranma develop, crea un tag RC, sube el proyecto dentro de CERT en artifactory y despliega en el ambiente de certificación.
* jenkins/Jenkinsfile-delivery-prod-pipeline.groovy: <br>
el cual despliega al ambiente de producción en base al tag RC y hace merge de la rama release/{version} a master.
Los servidores donde se desplegará el proyecto se definen en devops/ansible/hosts.

Las variables de entorno para cada ambiente son definidos en los siguientes archivos:

* devops/deploy/dev-vars.yml para desarrollo.
* devops/deploy/cert-vars.yml para certificación.
* devops/deploy/prod-vars.yml para producción.

### Ramas <a name="ramas"></a>

1. **`master`**: Contiene cada una de las versiones estables del proyecto. Se genera un tag para cada release.
2. **`develop`**: Contiene el código de desarrollo de la siguiente versión planificada del proyecto. Todo feature o bugfix llega previo a esta rama antes de ser desplegada.
3. **`feature`**: Cada una de estas ramas almacenan código de desarrollo con nuevas características.
4. **`bugfix`**: Es creada por el desarrollador para corregir issues en la rama de release. Una vez terminado su desarrollo, se incorporarán nuevamente a la rama develop.
5. **`release`**: Como las ramas feature, las ramas release también tienen que surgir de la rama develop. Contienen el código de la versión que se va a liberar próximamente.
6. **`hotfix`**: Surgen de la rama master y contienen una versión de producción con un error que se desea arreglar urgentemente. Una vez arreglado el error, se integra en master y develop.

estructura de rama feature/codigo-jira
```
feature/CIAM-12345
```

### Commits <a name="commits"></a>
Para el manejo de ramas en git se maneja el siguiente esquema

1. **`master`** : is the development branch.
2. **`develop`** : is the production branch.
3. **`feat`** : Introduce nuevas características en las base del código.
4. **`fix`** : este tipo es para todos las confirmaciones(commits) que se hagan para atacar algún bug o iSsues de la aplicación.
5. **`refactor`** : este tipo es para todos las confirmaciones(commits) que no corrige un error ni agrega una característica.
6. **`test`** : este tipo es para todos las confirmaciones(commits), que agregar pruebas faltantes o corregir pruebas existentes.
7. **`docs`** : este tipo es para todos las confirmaciones(commits), donde se realizan cambios en la documentación o los feature de las pruebas e2e.
8. **`style`** : este tipo es para todos las confirmaciones(commits),que no afectan el significado del código (espacio en blanco, formateo, puntos y comas faltantes, etc.).
9. **`ci`** : Cambio que afecta nuestro sistema de CI. Ficheros, scripts, (ejemplo: Travis, Cirle, BrowserStack, etc.).
perf: Cambio que mejora el performance.

estructura de commit variante: TICKET-JIRA descripcion, donde la descripcion esta en ingles

```
feat: CIAM-12345 add something
```
### Pull Request <a name="pull-request"></a>

1. Presentar el pull request, pero antes ver que se cumple lo anterior mencionado conteniendo lo siguiente:
    * Title: Debe ser el nombre del branch que queremos mergear, porque ya incluye el id del ticket del JIRA, el tipo de cambio que estamos realizando y una descripción concisa.
    * Description: Breve descripción del porqué es necesario realizar este Pull Request y lo que contiene.
    * Reviewers: Asignar los revisores acordados en el planning - Definir revisores de código
2. Nos dirigimos a la sección de Pull Requests para validar la creación de nuestro Pull Request
3. Finalmente, notificamos al revisor para que pueda iniciar con el proceso de Code Review

mas detalles puedo consultar [aqui](https://confluence.lima.bcp.com.pe/pages/viewpage.action?pageId=606737616)
