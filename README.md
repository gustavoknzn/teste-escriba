## Como Executar

- Importar projeto como Maven Project
- Aguardar baixar as depedências
  
   <p> URL Base: http://localhost:9564/api/"endpointDesejado"</p>
   <p> URL Swagger: http://localhost:9564/swagger-ui/</p>
  <p>URL Console H2: http://localhost:9564/h2-console</p>

- A cada inicio/reinicio da aplicação o banco é recriado em memoria (H2).
- O banco é populado via migrations
- Após a aplicação subir acessar a "URL Base: http://localhost:9564/api"

## Erros

<p><code>200 OK</code> Funcionando como esperado.</p>
<p><code>201 OK</code> Dado criado com sucesso.</p>
<p><code>400 Bad Request</code> Algum problema com os parâmetros.</p>
<p><code>404 Not Found</code> O recurso acessado não existe.</p>
<p><code>500 Server errors</code> Algum erro no servidor.</p>

