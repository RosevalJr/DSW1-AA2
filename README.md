# DSW1-AA2
Atividade AA-2 da disciplina de Desenvolvimento de Software para Web 1
- Sistema para oferta de vagas de estágios/empregos <br/>

# Professor responsável
- Delano Medeiros Beder <br/>

# Integrantes do Grupo
- 759375 Luís Felipe Corrêa Ortolan
- 758597 Roseval Donisete Malaquias Junior

# Roteiro de Execução
1- Instalar e inicializar o banco de dados Mysql
- Os integrantes deste grupo se basearem neste tutorial para realizar as configurações necessarias em um ambiente linux:
https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-20-04-pt
- O Mysql server é inicializado e populado com o seguintes comandos, segundo as configurações utilizadas no arquivo src/main/resources/application.properties do projeto:
<pre><code>$ cd AA1
$ mysql -u root -p
$ root
</pre></code>
- ** OBS **: Usuário e senha a serem utilizados pela aplicação podem ser facilmente alterados. No arquivo src/main/resources/application.properties do projeto é necessário alterar o usuário e senha escolhidos pela configuração Mysql, caso desejado.

3- Deploy do projeto
- Neste projeto foi utilizado o spring-boot 2.4.0. Diante disso, para realizar o deploy da aplicação é necessario executar o seguinte comando na raiz do projeto:
<pre><code>$ mvn spring-boot:run
</pre></code>

4- Acessando a aplicação pelo navegador
localhost:8080/

5- Observações do banco de dados populado
- O bando de dados criado seguindo esses passos já foi populado para que todas as funcionalidades implementadas neste sistema possam ser testadas.
- Para acessar as funcionalidades que necessitam do papel de administrador, entrar no sistema com LOGIN=admin, SENHA=admin.
- Para acessar as funcionliadade que necessitam do papel de usuário Profissional, pode-se entrar no sistema com LOGIN=rdmaljr@hotmail.com SENHA=123password ou LOGIN=marcela@hotmail.com SENHA=123password ou LOGIN=jose@estudante.ufscar.br SENHA=123password.
- Para acessar as funcionalidade que necessitam do papel de usuário Empresa, pode-se entrar no sistema com LOGIN=microsoft@hotmail.com SENHA=123password ou LOGIN=roseval@estudante.ufscar.br SENHA=123password.

# Checklist de Requisitos Concluídos
- Todos os requisitos especificados pelo professor foram implementados e integrados na aplicação.






