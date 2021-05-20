# v2wsmart
Backend application

<h3>1.Usado Spring Boot + JPA</h3>
<h3>2.Padrão MVC</h3>
<h3>3.Banco MySql</h3>
<h3>4.Banco teste H2</h3>


Gerenciamento de Produtos

   Métodos da aplicação:

<h2>Inserindo um produto</h2>
<h3>1 - POST ("/products")</h3>

<pre><code>
{
  "name": "iPhone 11",
  "description": "iPhone 11 64GB",
  "price": 4000.00
}
</code></pre>
  
  
<h2>Alterando um produto</h2>
<h3>2 - PUT ("/products/{id}")</h3>
<pre><code>
{
  "name": "iPhone 12",
  "description": "iPhone 12 128GB",
  "price": 7000.00
}
</code></pre>

<h2>Buscando um produto</h2>
<h3>3 - GET ("/products/{id}")</h3>


<h2>Deletando um produto</h2>
<h3>4 - DELETE ("/products/{id}")</h3>
