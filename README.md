# midpoint-custom-service-overlay
Example of a midPoint overlay project that implements a custom web service.

The web service is implemented in the midpoint-custom-service-server. It is
implemented by using JAX-WS contract-first development. WSDL file is part of
the project and the server code is generated from that.

The midpoint-custom-service-overlay is an overlay project that is using
the web service client and itegrates it with midPoint.
The final midpoint.war will be built in
midpoint-custom-service-overlay/target/midpoint.war

There is also testing web service client in midpoint-custom-service-client.

See https://wiki.evolveum.com/display/midPoint/Customization+With+Overlay+Project
for more details about midPoint overlay projects.
