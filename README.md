
# Desenvolvimento de RPG aplicando o Padrão de Projeto Abstract Factory e Conceitos IoC


## 🏹 Objetivo
Explorar o uso do Abstract Factory juntamente com o Spring Framework, para o desenvolvimento da aplicação Web de um RPG 





## 🚀 Funcionalidades

- Cadastro de personagens e persistência deles
- Batalha entre Personagens e Boss
- Linguagem própria para imersão no universo do RPG
- Responsivo


## ⚙️ Estrutura aplicada
| Nome | Objetivo |
|-------|---------|
| Controller | Resposável pelas solicitações HTTP |
| Model | Responsável pelo armazenamento das Classes |
| Service | Responsável pelas classes que tenham Lógica de Negócio |
| Repository | Responsável pelas classes que persistem os dados |




## 🛠 Ferramentas e Tecnologias

<img loading="lazy" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/html5/html5-original-wordmark.svg" width="40" height="40"/> 
<img loading="lazy" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg"  width="40" height="40"/> 
<img loading="lazy" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/bootstrap/bootstrap-original.svg" width="40" height="40"/> 
<img loading="lazy" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" width="40" height="40"/> 
<img loading="lazy" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/git/git-original.svg" width="40" height="40"/>


## 🔍 Por que e como Aplicar a Abstract Factory

<b>Motivo:</b> O padrão Abstract Factory tem como objetivo aplicar um padrão de código para objetos que se relacionam, o RPG do presente projeto tem 4 tipos de classes:
- Mago
- Feiticeira
- Guerreiro
- Gladiadora

Como podemos notar todos eles são Personagens, com vida, nome e personalidade, essa personalidade pode criar Heroicos ou Malvados, e é aqui que entra o principal motivo de aplicarmos o Abstract Factory, ele vai nos auxiliar a criar essas 4 classes nessas duas Personalidades.

### Classe abstrata Personagem
A classe que todos os personagens concreto devem herdar, cada personagem pode ter atributos e metódos a mais

```java
  public abstract class Personagem {
    protected String nome;
    protected int vida;
    protected int atq;
    protected int def;
    protected String personalidade;
}
```

### Classes Abstratas de Personagens
```java
public abstract class Feiticeira extends Personagem {
    public Feiticeira(String nome, int vida, int atq, int def, String personalidade) {
        super(nome, vida, atq, def, personalidade);
    }
}
```

### Classe para criação dos Personagens Concretos dos dois tipos ( Heroico e Malvado )
```java
public class FeiticeiraHeroico extends Feiticeira{
    public FeiticeiraHeroico(String nome) {
        super(nome, 100, 38, 30, "Heroico");
        setCaminhoDaImg("/img/personagens/feiticeiraHeroico.png");
        setCaminhoDaImgSimbolo("/img/personagens/magoSimbolo.png");
    }
}
```

### Interface

A Interface para as fabricas concretas Heroico e Malvado poderem implementar seus metódos
```java
  public interface FabricaPersonagem {
    Guerreiro criarGuerreiro(String nome);
    Mago criarMago(String nome);
    Gladiadora criarGladiadora(String nome);
    Feiticeira criarFeiticeira(String nome);
}
```
### Fabrica Concreta de Heroicos e Malvados
Essas fabricas devem implementar a interface e instanciar os personagens concretos
```java
public class FabricaPersonagemHeroico implements FabricaPersonagem {

    @Override
    public Mago criarMago(String nome) {
        return new MagoHeroico(nome);
    }

    @Override
    public Gladiadora criarGladiadora(String nome) {
        return new GladiadoraHeroico(nome);
    }

    @Override
    public Feiticeira criarFeiticeira(String nome) {
        return new FeiticeiraHeroico(nome);
    }

    @Override
    public Guerreiro criarGuerreiro(String nome) {
        return new GuerreiroHeroico(nome);
    }
}
```

Toda a estrutura do Abstract Factory foi feita, agora implementamos toda essa lógica na parte de Cadastro do personagem.

# 🕵️‍♀️ Conclusão
Ao utilizarmos esse padrão, otimizamos a implementação de novos tipos de personagens e personalidades no RPG, além de dividir as funções para cada respectiva classe.
Utilizando o Spring Framework e seus conceitos conseguimos otimizar as configurações para aplicação WEB e focar em criar toda lógica dela mais rapidamente, além de conseguir utilizar o IoC para gerenciar todas as dependências do nosso código.

## 👩‍💻 Desenvolvedoras

 - [Giuliana Gralha](https://github.com/Giuliana09)
 - [LarissaSL](https://github.com/LarissaSL)
 - [Silvana Menezes](https://github.com/SilvanaMenezes)
