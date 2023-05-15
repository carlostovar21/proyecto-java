declare namespace ns1 = "http://example.com/empleadoservice";

declare function local:transformarSolicitud($payload as element()) as element() {
  <ns1:crearEmpleado>
    <ns1:id>{$payload.id}</ns1:id>
    <ns1:nombre>{$payload.nombre}</ns1:nombre>
    <ns1:salario>{$payload.salario}</ns1:salario>
  </ns1:crearEmpleado>
};
