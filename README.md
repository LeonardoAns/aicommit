<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; line-height: 1.6; max-width: 800px; margin: 0 auto; padding: 20px; color: #333;">
    <h1 style="color: #2c3e50; border-bottom: 2px solid #3498db; padding-bottom: 10px;">AI Commit</h1>
    <section>
        <h2 style="color: #2980b9; margin-top: 30px;">Resumo</h2>
        <p>Este projeto é uma ferramenta que utiliza OpenAI para auxiliar na geração de commits automatizados para repositórios Git. Ele permite que você configure e execute facilmente a geração de mensagens de commit de acordo com as mudanças realizadas no seu código.</p>
    </section>
    <section>
        <h2 style="color: #2980b9; margin-top: 30px;">Requisitos</h2>
        <ul>
            <li><strong>Java 21+</strong> (Certifique-se de ter o JDK 21 ou superior instalado em sua máquina)</li>
            <li><strong>API Key da OpenAI</strong>: Para utilizar a funcionalidade de geração de mensagens de commit com o modelo GPT, é necessário ter uma chave de API válida da OpenAI.</li>
        </ul>
    </section>
    <section>
        <h2 style="color: #2980b9; margin-top: 30px;">Como Clonar</h2>
        <p>Clone este repositório utilizando o comando Git:</p>
        <pre style="background-color: #f8f9fa; padding: 15px; border-radius: 5px; overflow-x: auto; border-left: 3px solid #3498db;"><code style="background-color: #f8f9fa; padding: 2px 5px; border-radius: 3px; font-family: 'Courier New', Courier, monospace;">git@github.com:LeonardoAns/aicommit.git</code></pre>
    </section>
    <section>
        <h2 style="color: #2980b9; margin-top: 30px;">Como Rodar o Projeto</h2>
        <article>
            <h3 style="color: #16a085;">Instalar Dependências e Gerar o .jar</h3>
            <p>Execute os seguintes comandos no diretório do projeto para limpar, compilar e gerar o arquivo .jar:</p>
            <pre style="background-color: #f8f9fa; padding: 15px; border-radius: 5px; overflow-x: auto; border-left: 3px solid #3498db;"><code style="background-color: #f8f9fa; padding: 2px 5px; border-radius: 3px; font-family: 'Courier New', Courier, monospace;">mvn clean install</code></pre>
            <p>Após a execução do comando, o arquivo .jar será gerado em <code style="background-color: #f8f9fa; padding: 2px 5px; border-radius: 3px; font-family: 'Courier New', Courier, monospace;">target/ai_commit-1.0-SNAPSHOT.jar</code>.</p>
        </article>
        <article>
            <h3 style="color: #16a085;">Criar o Arquivo .bat</h3>
            <p>Para facilitar a execução do arquivo, abra o bloco de notas e cole o seguinte conteúdo:</p>
            <pre style="background-color: #f8f9fa; padding: 15px; border-radius: 5px; overflow-x: auto; border-left: 3px solid #3498db;"><code style="background-color: #f8f9fa; padding: 2px 5px; border-radius: 3px; font-family: 'Courier New', Courier, monospace;">@echo off
java -jar "C:\Users\SEU_USER\CAMINHO_DO_PROJETO\ai_commit\target\ai_commit-1.0-SNAPSHOT.jar" %*</code></pre>
            <p>Após colar o conteúdo, clique em "Salvar como..." e altere a extensão para .bat.</p>
        </article>
        <article>
            <h3 style="color: #16a085;">Salvar o Arquivo .BAT em Scripts</h3>
            <p>Salve o arquivo .bat no diretório <code style="background-color: #f8f9fa; padding: 2px 5px; border-radius: 3px; font-family: 'Courier New', Courier, monospace;">C:\Users\SEU_USER\scripts</code> (substitua <code style="background-color: #f8f9fa; padding: 2px 5px; border-radius: 3px; font-family: 'Courier New', Courier, monospace;">SEU_USER</code> pelo seu nome de usuário).</p>
        </article>
        <article>
            <h3 style="color: #16a085;">Adicionar o Caminho dos Scripts ao Path do Sistema</h3>
            <ol>
                <li>Vá até as Variáveis de Ambiente do Sistema (Procure por "Variáveis de ambiente" no menu iniciar do Windows).</li>
                <li>Encontre a variável <code style="background-color: #f8f9fa; padding: 2px 5px; border-radius: 3px; font-family: 'Courier New', Courier, monospace;">Path</code> na seção "Variáveis de Sistema" e clique em "Editar".</li>
                <li>Adicione o caminho do diretório onde você salvou o arquivo .bat. Exemplo:
                    <pre style="background-color: #f8f9fa; padding: 15px; border-radius: 5px; overflow-x: auto; border-left: 3px solid #3498db;"><code style="background-color: #f8f9fa; padding: 2px 5px; border-radius: 3px; font-family: 'Courier New', Courier, monospace;">C:\Users\SEU_USER\scripts</code></pre>
                </li>
            </ol>
        </article>
        <article>
            <h3 style="color: #16a085;">Executar o Script</h3>
            <p>Agora você pode executar o comando a partir de qualquer diretório no terminal, apenas digitando:</p>
            <pre style="background-color: #f8f9fa; padding: 15px; border-radius: 5px; overflow-x: auto; border-left: 3px solid #3498db;"><code style="background-color: #f8f9fa; padding: 2px 5px; border-radius: 3px; font-family: 'Courier New', Courier, monospace;">aicommit</code></pre>
            <p>Isso irá rodar o .jar e executar o programa com os parâmetros fornecidos.</p>
        </article>
    </section>
    <div style="background-color: #e7f5fe; padding: 10px; border-left: 4px solid #3498db; margin: 15px 0;">
        <p><strong>Observação:</strong> Lembre-se de substituir todas as ocorrências de "SEU_USER" pelo seu nome de usuário real do Windows e ajustar os caminhos conforme necessário.</p>
        <p><strong>Observação:</strong> Ajuste o número de tokens conforme necessário para mensagens mais completas.</p>    </div>
</body>
</html>
