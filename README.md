# v2wsmart
Backend application

<h3>1.Usado Spring Boot + JPA</h3>
<h3>2.Padrão MVC</h3>
<h3>3.Banco MySql</h3>
<h3>4.Banco teste H2</h3>


Gerenciamento de Produtos

   Métodos da aplicação:

<h2>Inserindo um produto</h2>
<h3>1 - POST (/products)</h3>

<pre><code>
{
  "cpf": "11122233300",
  "name": "Walter Porfirio"
}
</code></pre>
  
  
<h2>Inserindo uma Pauta ao banco</h2>
<h3>2 - POST (/guidelines)</h3>
<pre><code>
{
    "guideline": "Nome da Pauta"
}
</code></pre>

<h2>Inserindo uma votação, passando um JSON com a Pauta que deseja votar, o associado que deseja votar, e por fim seu voto.</h2>
<h3>3 - POST (/voting)</h3>
<pre><code>
{"guideline": {"id": 1}, "associated": {"id": 1}, "choice": true }
</code></pre>

<h2>Iniciando uma seção de votos, passando o "ano/mês/diaThora:minutos", minutos que a seção ficará aberta, e a pauta.</h2>
<h3>4 - POST (/session)</h3>
<pre><code>
{
    "startTime": "2021-05-11T15:30",
    "sessionMinutes": null,
    "guideline": {"id": 1}
}
</code></pre>

<h2>Contabilizando os votos...</h2>
<h3>5 - GET (/sumVoting?guidelineId=1)</h3>
KEY: guidelineId VALUE: 1
<pre><code>
{
    "guideline": {
        "id": 1,
        "guideline": "Pauta principal"
    },
    "sumVotes": 3,
    "result": false
}
</code></pre>
