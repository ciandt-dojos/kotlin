# Kotlin



## 22/03/2018
## Participantes
  - amandak
  - andrech
  - fmoreno
  - jpimentel
  - marcosvc
  - charles
### Solução planejada para o app Android
- Início da estrutura para app Android
        - Firebase
             /Jogo
                 /id_jogo 
                    /tabuleiros
                     /jogadas
        - Layout
            Recycler view para montar o tabuleiro
            Cada tabuleiro será uma lista, navios e jogadas.
                DiffUtils
                Célula pode estar em 3 status - para quem está fazendo a jogada
                    Padrão - não foi jogado
                    Água - jogou e errou
                    Bomba - Jogou e acertou
                Célula pode estar em doi status - para quem está esperando a jogada do oponente
                    Padrão - vazio (água)
                    Ocupado - onde foi colocado o navio
                Para preencher o tabuleiro
                    Botão com a orientação - horizontal e vertical
                    Selecionar o tipo de navio
                    Indicar a célula inicial e o jogo "desenha" o navio com as posições, seguindo a orientação
                    
        - Vir com a estrutura do projeto pronto.

### Próximos passos:
- O bottom-sheet foi implementado, falta colorir as celulas referente ao navio.
- Adicionar o navio
- Desabilitar o navio que já possui quantidade máxima
- Validar a orientação e navio de acordo com a célula (quantidade disponível)

### Pontos positivos:
- o desenvolvimento andou
- foi poíssvel ver mais sobre o front-end, pois antes só víamos back-end
- estudo de uma estrutura - BottomSheet

### Pontos negativos:
- Atraso no início
- Adaptador não funciona em todas as máquinas - projetar tela
- Convesa paralela

## 08/02/2018
### Participantes:
  - amandak
  - andrech
  - fmoreno
  - jpimentel

### Solução planejada para o app Android
    - Início da estrutura para app Android
        - Firebase
             /Jogo
                 /id_jogo 
                    /tabuleiros
                     /jogadas
        - Layout
            Recycler view para montar o tabuleiro
            Cada tabuleiro será uma lista, navios e jogadas.
                DiffUtils
                Célula pode estar em 3 status - para quem está fazendo a jogada
                    Padrão - não foi jogado
                    Água - jogou e errou
                    Bomba - Jogou e acertou
                Célula pode estar em doi status - para quem está esperando a jogada do oponente
                    Padrão - vazio (água)
                    Ocupado - onde foi colocado o navio
                Para preencher o tabuleiro
                    Botão com a orientação - horizontal e vertical
                    Selecionar o tipo de navio
                    Indicar a célula inicial e o jogo "desenha" o navio com as posições, seguindo a orientação
                    
        - Vir com a estrutura do projeto pronto.

### Pontos positivos:
  - Planejamento de como será feito o projeto em Android conforme documentado acima
  - Explicação de conceitos importantes para mobile (views)

### Pontos negativos:
  - Falta do espelhamento da TV;
  - Tempo reduzido devido a falta do ambiente configurado;

### Próximos passos:
  - Garantir que o ambiente (IDE, TV, etc) esteja configurado antes do início do Dojo;
  - Finalizar o desafio da batalha naval no Android;
  - Montar ambiente de backup
  - Definir uma tela a ser montada - desenhar tabuleiro das jogadas (já mostrando os enums)
  - Ler sobre recycler view
  - Verificar as imagens a serem utilizadas

---
## 02/02/2018

### Participantes:
  - ailtonb
  - amandak
  - andrech
  - fmoreno
  - jpimentel
  - lcamacho
  - marcosvc

### Pontos positivos:
  - Familiarização com a linguagem;
  - Levantamento do que deve ser feito separado em tarefas (ToDo/Done);

### Pontos negativos:
  - Não foi produtivo em relação ao ultimo
  - Falta do espelhamento da TV;
  - Tempo reduzido devido a falta do ambiente configurado;

### Próximos passos:
  - Garantir que o ambiente (IDE, TV, etc) esteja configurado antes do início do Dojo;
  - Finalizar o desafio da batalha naval no Android;


## 25/1/2018

### Participantes: 
  - ailtonb
  - amandak
  - andrech
  - fmoreno
  - lcamacho

### Pontos positivos:
  - Muito mais produtivo devido a quantidade de participantes;
  - Levantamento do que deve ser feito separado em tarefas (ToDo/Done);
  - Familiarização com a linguagem;

### Pontos negativos:
  - Falta do espelhamento da TV;
  - Tempo reduzido devido a falta do ambiente configurado;

### Próximos passos:
  - Garantir que o ambiente (IDE, TV, etc) esteja configurado antes do início do Dojo;
  - Finalizar o desafio da batalha naval;
 
## 18/1/2018

### Desafios:
  - Batalha Naval
  
### Participantes: 
  - amandak
  - andrech
  - fmoreno
  - jpimentel
  - lcamacho
  - marcosvc
  - patricio

### Pontos positivos:
  - Definiçao do projeto foi melhor que o anterior.
  - Do fato da equipe ser menor, a equipe teve uma sinergia melhor.
  - Aprendemos novas estruturas
  
### Pontos negativos:
  - Nao seguimos a risca o TDD.
  - Definicao do timebox da solucao foi de 50 minutos.
  - Atencao ao termino do rodizio do Dojo
  
### Próximos passos:
  - Concluir a soluçao
  - Mais Foco
  - Gerenciar o tempo do Dojo

---
## 11/1/2018

### Desafios:
  - Jogo da velha
  
### Participantes: 
  - amandak
  - andrech
  - ailtonb
  - csoares
  - enir
  - fmoreno
  - guilhermel
  - jpimentel
  - lcamacho
  - marcosvc

### Pontos positivos:
  - Dois novos participante
  - Trabalhamos um pouco mais a estrutura da linguagem
  - o trabalho com o piloto e copiloto houve melhoras
  
### Pontos negativos:
  - Desafio não foi concluido
  - Fizemos a solução, porém não foi aplicada completamente porque os participantes não entederam a solução comum todo
  - Faltou definir o escopo de cada classe
  - A definição da solução não foi completa(ainda perdemos tempo durante a codificação)

### Próximos passos:
  - Explorar mais as estruturas de dados e as caracteristicas da linguagem
  - dividir turma
---
## 4/1/2018

### Desafios:
  - http://
  
### Participantes: 
  - amandak
  - csoares
  - jpimentel
  - lcamacho
  - marcosvc
  - vilmarbf

### Pontos positivos:
  - Três novos participantes 
  - Piloto e copiloto foram mais participativos
  - 7 minutos parece funcionar bem
  - Foi decidio algoritmo antes do timer
  
### Pontos negativos:
  - Conversas paralelas(devido só piloto e copoloto falarem)
  - Participantes faltaram
  - A definição da solução não foi completa(ainda perdemos tempo durante a codificação)

### Próximos passos:
  - Arrumar problemas para que possa explorar a linguagem
  - Explorar mais as estruturas de dados e as caracteristicas da linguagem
--- 

## 14/12/2017

### Desafios:
  - http://dojopuzzles.com/problemas/exibe/caixa-eletronico/
  
### Participantes: 
  - andrech
  - csoares
  - eferraz
  - guilhermel 
  - jpimentel
  - marcosvc
  - patricio

### Pontos positivos:
  - Desafio parecia simples, mas foi interessante
  - Dois novos participantes 
  
### Pontos negativos:
  - Esquecimento do timer
  - Tempo de 5min é pouco tempo
  
### Próximos passos:
  - Enquanto estiver propondo solução não contabilizar o tempo
  - Não induzir o piloto
  - Melhorar atuação do co-piloto
  
--- 

## 07/12/2017

### Desafios:
  - http://dojopuzzles.com/problemas/exibe/lampadas-no-corredor/
  - http://br.spoj.com/problems/ENCOTEL/
  
### Participantes: 
  - andersonr
  - andrech
  - csoares
  - daianefs
  - guilhermel 
  - jpimentel
  - patricio

### Pontos positivos:
  - Lanche
  - Participação dos envolvidos 
  - Desafios interessantes
  - Interação entre os participantes
  - 1h 30m tempo suficiente 
  
### Pontos negativos:
  - Desconhecimento da linguagem
  
### Próximos passos:
  - Capacitação dos participantes iniciais para que possamos expandir
  - Definir frequência 
