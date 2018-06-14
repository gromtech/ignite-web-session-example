# Apache Ignite - Web Session Clustering Example (Jetty)

### How to run:

* Start Ignite server node (use server-config.xml).
* Run jetty: ```mvn jetty:run ```

### Endpoints:

* `/list` - get attributes list
* `/add/<key>/<value>` - add attribute
* `/remove/<key>` - remove attribute 