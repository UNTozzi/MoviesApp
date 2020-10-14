package br.usjt.ads20.moviesapp.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Data {
    public static Movie[] searchMovies(String key) {
        ArrayList<Movie> list = createMovie();

        ArrayList<Movie> filter;

        if (key == null || key.length() == 0) {
            filter = list;
        }
        else {
            filter = new ArrayList<>();
            for (Movie movie : list) {
                String name = movie.getTitle();
                if (name.toUpperCase().contains(key.toUpperCase())) {
                    filter.add(movie);
                }
            }
        }
        Movie[] movies = filter.toArray(new Movie[0]);
        Arrays.sort(movies);
        return movies;
    }

    public static ArrayList<String> generateMoviesList() {
        ArrayList<String> list = new ArrayList<>();

        list.add("Aventura: Guerra nas Estrelas (1977)");
        list.add("Fantasia: O Senhor dos Anéis: O Retorno do Rei");
        list.add("Ação: Matrix");
        list.add("Aventura: De Volta para o Futuro");
        list.add("Ficção Científica: Jornada nas Estrelas");
        list.add("Aventura: Os Goonies");
        list.add("Ficção Científica: Blade Runner, o Caçador de Androides");
        list.add("Suspense: Allien");
        list.add("Drama: Platoon");
        list.add("Ação: Os Vingadores");
        list.add("Thriller: Pulp Fiction");
        list.add("Aventura: Os Caçadores da Arca Perdida");
        list.add("Terror: It - A coisa");
        list.add("Terror: Psicose");
        list.add("Comédia: Monty Python em Busca do Cálice Sagrado");
        list.add("Terror: Os Garotos Perdidos");
        list.add("Suspense: Seven, os Sete Pecados Capitais");
        list.add("Ação: Kill Bill");
        list.add("Fantasia: Alice no País das Maravilhas");
        list.add("Anime: Akira");
        list.add("Terror: Hereditário");

        return list;
    }

    public static ArrayList<Category> createCategory() {
        ArrayList<Category> list = new ArrayList<>();
        list.add(new Category(1, "Não Cadastrado"));
        list.add(new Category(28, "Ação"));
        list.add(new Category(12, "Aventura"));
        list.add(new Category(16, "Animação"));
        list.add(new Category(35, "Comédia"));
        list.add(new Category(80, "Crime"));
        list.add(new Category(99, "Documentário"));
        list.add(new Category(18, "Drama"));
        list.add(new Category(10751, "Família"));
        list.add(new Category(14, "Fantasia"));
        list.add(new Category(36, "História"));
        list.add(new Category(27, "Horror"));
        list.add(new Category(10402, "Musical"));
        list.add(new Category(9648, "Mistério"));
        list.add(new Category(10749, "Romance"));
        list.add(new Category(878, "Ficção Científica"));
        list.add(new Category(10770, "Movie para TV"));
        list.add(new Category(53, "Suspense"));
        list.add(new Category(10752, "Guerra"));
        list.add(new Category(37, "Western"));

        return list;
    }

    public static ArrayList<Movie> createMovie() {
        ArrayList<Movie> list = new ArrayList<>();
        Movie movie;
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        movie = new Movie();
        movie.setPopularity(847.503);
        movie.setPosterPath("dGVUiqnahQ4ZZRchGRpO2SyhtQY.jpg");
        movie.setBackdropPath("gEjNlhZhyHeto6Fy5wWy5Uk3A9D.jpg");
        movie.setCategory(new Category(28, "Ação"));
        movie.setDirector("Yeon Sang-ho");
        movie.setTitle("Península");
        movie.setDescription("O movie decorre no mesmo mundo do primeiro movie, mas acontece quatro " +
                "anos depois do original. Gang Dong-Won é um antigo soldado que conseguiu escapar " +
                "da Coreia do Sul infestada por zombies. O vírus fez colapsar governos pelo mundo " +
                "e a Coreia do Sul tornou-se numa enorme favela. O ex-soldado tem como missão " +
                "entrar no país para recuperar algo muito valioso, mas depara-se com um grupo de " +
                "não-infetados que precisam de ser salvos.");
        try {
            movie.setReleaseDate((Date) formatter.parse("2020-08-27"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        list.add(movie);
        movie = new Movie();
        movie.setPopularity(781.209);
        movie.setPosterPath("teDX74nsxkv2ysWvNT5EPXQ9E.jpg");
        movie.setBackdropPath("qVygtf2vU15L2yKS4Ke44U4oMdD.jpg");
        movie.setCategory(new Category(28, "Ação"));
        movie.setDirector("Henry Joost & Ariel Schulman");
        movie.setTitle("Project Power: Descobre o Poder");
        movie.setDescription("Os caminhos de um ex-soldado, uma adolescente e um polícia cruzam-se " +
                "em Nova Orleães, enquanto procuram a fonte de uns novos comprimidos que provocam " +
                "poderes temporários.");
        try {
            movie.setReleaseDate((Date) formatter.parse("2020-08-14"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        list.add(movie);
        movie = new Movie();
        movie.setPopularity(352.029);
        movie.setPosterPath("p7RjlzDLV4KksrWtyve1Rg40nLv.jpg");
        movie.setBackdropPath("fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg");
        movie.setCategory(new Category(12, "Aventura"));
        movie.setDirector("Tony Cervone");
        movie.setTitle("Scooby!");
        movie.setDescription("O primeiro movie completo de animação chega aos grandes ecrãs com " +
                "histórias nunca contadas das origens de Scooby-Doo e um dos maiores mistérios " +
                "da carreira de Mystery Inc.. Vamos ver como Shaggy e Scooby se conheceram e como " +
                "foram apresentados aos jovens detectives Fred, Velma e Daphne para formarem a " +
                "Mystery Inc.. Agora o grupo tem o seu maior desafio, que envolve um enredo para " +
                "libertar o cão fantasma Cerberus no mundo.");
        try {
            movie.setReleaseDate((Date) formatter.parse("2020-08-07"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        list.add(movie);
        movie = new Movie();
        movie.setPopularity(346.752);
        movie.setPosterPath("knfExByNW2jCwtmIuwYYxzPKpkm.jpg");
        movie.setBackdropPath("m0ObOaJBerZ3Unc74l471ar8Iiy.jpg");
        movie.setCategory(new Category(28, "Ação"));
        movie.setDirector("Gina Prince-Bythewood");
        movie.setTitle("A Velha Guarda");
        movie.setDescription("Quatro guerreiros imortais, que protegem a humanidade em segredo há " +
                "séculos, são perseguidos pelos seus misteriosos poderes, justamente quando " +
                "descobrem uma nova imortal.");
        try {
            movie.setReleaseDate((Date) formatter.parse("2020-07-10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        list.add(movie);
        movie = new Movie();
        movie.setPopularity(328.69);
        movie.setPosterPath("sTKl7J5OWnsZSTRiKPIvPx4ngBG.jpg");
        movie.setBackdropPath("upUy2QhMZEmtypPW3PdieKLAHxh.jpg");
        movie.setCategory(new Category(28, "Ação"));
        movie.setDirector("Adil El Arbi & Bilall Fallah");
        movie.setTitle("Bad Boys Para Sempre");
        movie.setDescription("Will Smith e Martin Lawrence estão de regresso às ruas de Miami, a dar " +
                "corpo aos detectives Mike Lowrey e Marcus Burnett, do Departamento de Narcóticos. " +
                "Agora, ao mesmo tempo que lidam com problemas a nível pessoal – que incluem " +
                "mudanças de carreira, envelhecimento e crises de meia-idade –, vão ter de " +
                "enfrentar Armando Armas, o líder do mais perigoso cartel de drogas a actuar em " +
                "todo o estado da Flórida.");
        try {
            movie.setReleaseDate((Date) formatter.parse("2020-01-30"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        list.add(movie);
        movie = new Movie();
        movie.setPopularity(311.359);
        movie.setPosterPath("A50Ngq9lh9aCTGHC6kttrppHNoF.jpg");
        movie.setBackdropPath("xNOiv6DZZjH7ABoUUDP0ZynouU.jpg");
        movie.setCategory(new Category(28, "Ação"));
        movie.setDirector("Cathy Yan");
        movie.setTitle("Aves de Rapina");
        movie.setDescription("Harley Quinn decide lutar pela sua emancipação e separa-se de Joker. " +
                "Uma notícia que agrada a muitos que querem contar com a sua ajuda para outros " +
                "planos perigosos. Mas, Harley junta-se aos super-heróis Black Canary, Huntress e " +
                "Renee Montoya para salvar uma jovem.");
        try {
            movie.setReleaseDate((Date) formatter.parse("2020-02-06"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        list.add(movie);
        movie = new Movie();
        movie.setPopularity(268.133);
        movie.setDirector("Josh Boone");
        movie.setTitle("Os Novos Mutantes");
        try {
            movie.setReleaseDate((Date) formatter.parse("2020-10-08"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        movie.setCategory(new Category(28, "Ação"));
        movie.setBackdropPath("eCIvqa3QVCx6H09bdeOS8Al2Sqy.jpg");
        movie.setDescription("Num hospital isolado, um grupo de jovens mutantes é mantido enclausurado " +
                "para acompanhamento psiquiátrico. Quando estranhos acontecimentos têm lugar, as " +
                "suas novas habilidades mutantes e as suas amizades serão postas à prova, enquanto " +
                "lutam pela sobrevivência.");
        movie.setPosterPath("RcWaW43UWIJzhIp6bcmui2efd.jpg");
        list.add(movie);
        movie = new Movie();
        movie.setPopularity(284.474);
        movie.setPosterPath("el7iWlogQ4Mv6A0qvBn4ZyxHGiW.jpg");
        movie.setBackdropPath("xXBnM6uSTk6qqCf0SRZKXcga9Ba.jpg");
        movie.setCategory(new Category(28, "Ação"));
        movie.setDirector("Aaron Schneider");
        movie.setTitle("Missão Greyhound");
        movie.setDescription("No início da Segunda Guerra Mundial, um conjunto internacional formado " +
                "por 37 navios aliados, liderado pelo comandante Ernest Krause na sua primeira " +
                "missão à frente de um destroyer norte-americano, atravessa as águas traiçoeiras " +
                "do Atlântico Norte enquanto é perseguido por matilhas de submarinos nazis U-Boot.");
        try {
            movie.setReleaseDate((Date) formatter.parse("2020-07-10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        list.add(movie);
        movie = new Movie();
        movie.setPopularity(252.159);
        movie.setPosterPath("u3B2YKUjWABcxXZ6Nm9h10hLUbh.jpg");
        movie.setBackdropPath("ToEZvF2Obp9zNZbY5ELVnmrW.jpg");
        movie.setCategory(new Category(18, "Drama"));
        movie.setDirector("Jenny Gage");
        movie.setTitle("After");
        movie.setDescription("Inspirado no best-seller de Anna Todd, “After” conta-nos a história " +
                "de Tessa (Josephine Langford), estudante aplicada, filha perfeita e namorada leal " +
                "da sua paixão da escola secundária, no momento em que esta entra na universidade. " +
                "Armada com grandes ambições para o futuro, o seu mundo protegido quebra quando " +
                "conhece o misterioso Hardin Scott (Hero Tiffin), um rebelde carismático que a " +
                "levará a questionar tudo o que pensava saber sobre si e sobre os seus objetivos " +
                "de vida…");
        try {
            movie.setReleaseDate((Date) formatter.parse("2019-04-11"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        list.add(movie);
        movie = new Movie();
        movie.setPopularity(278.387);
        movie.setPosterPath("Kt9iFdTu5TbAm7tNfc876mrWU.jpg");
        movie.setBackdropPath("stmYfCUGd8Iy6kAMBr6AmWqx8Bq.jpg");
        movie.setCategory(new Category(28, "Ação"));
        movie.setDirector("Jeff Fowler");
        movie.setTitle("Sonic: O Movie");
        movie.setDescription("Baseado no videojogo da Sega, sucesso à escala global, Sonic: O Movie " +
                "conta a história do ouriço mais rápido do mundo a partir do momento em que este " +
                "chega à sua nova casa – o planeta Terra. Nesta comédia e aventura live-action, " +
                "Sonic e o seu novo melhor amigo Tom  juntam-se para defender o planeta do génio " +
                "do mal, o Dr. Robotnik, e dos seus planos para domínio do mundo.");
        try {
            movie.setReleaseDate((Date) formatter.parse("2020-02-13"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        list.add(movie);
        movie = new Movie();
        movie.setPopularity(249.127);
        movie.setPosterPath("xLxgVxFWvb9hhUyCDDXxRPPnFck.jpg");
        movie.setBackdropPath("n6bUvigpRFqSwmPp1m2YADdbRBc.jpg");
        movie.setCategory(new Category(80, "Crime"));
        movie.setDirector("Todd Phillips");
        movie.setTitle("Joker");
        movie.setDescription("Arthur Fleck é um homem que enfrenta a crueldade e o desprezo da " +
                "sociedade, juntamente com a indiferença de um sistema que lhe permite passar da " +
                "vulnerabilidade para a depravação. Durante o dia é um palhaço e à noite luta para " +
                "se tornar um artista de stand-up comedy…mas descobre que é ele próprio a piada. " +
                "Sempre diferente de todos em seu redor, o seu riso incontrolável e inapropriado, " +
                "ganha ainda mais força quando tenta contê-lo, expondo-o a situações ridículas e " +
                "até à violência. Preso numa existência cíclica que oscila entre o precipício da " +
                "realidade e da loucura, uma má decisão acarreta uma reacção em cadeia de eventos " +
                "crescentes e, por fim, mortais.");
        try {
            movie.setReleaseDate((Date) formatter.parse("2019-10-03"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        list.add(movie);
        movie = new Movie();
        movie.setPopularity(271.014);
        movie.setPosterPath("Z7AJiQhocA20MkI5JXZ6OjTxEW.jpg");
        movie.setBackdropPath("lP5eKh8WOcPysfELrUpGhHJGZEH.jpg");
        movie.setCategory(new Category(28, "Ação"));
        movie.setDirector("Dave Wilson");
        movie.setTitle("Bloodshot");
        movie.setDescription("Baseado no best-seller de banda desenhada, Vin Diesel protagoniza " +
                "“Bloodshot” na pele de Ray Garrison, um soldado recentemente morto em combate e " +
                "ressuscitado como o super – humano Bloodshot da empresa RST. Com um exército de " +
                "nanotecnologia nas suas veias, Rayé uma força imparável – mais forte do que nunca " +
                "e capaz de se curar instantaneamente. Mas, ao controlar o seu corpo, a empresa " +
                "controla também a sua mente e as suas memórias. Agora, Ray não sabe o que é real " +
                "e o que não é, mas está decidido a descobrir a verdade.");
        try {
            movie.setReleaseDate((Date) formatter.parse("2020-03-12"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        list.add(movie);
        movie = new Movie();
        movie.setPopularity(252.152);
        movie.setPosterPath("k68nPLbIST6NP96JmTxmZijEvCA.jpg");
        movie.setBackdropPath("wzJRB4MKi3yK138bJyuL9nx47y6.jpg");
        movie.setCategory(new Category(28, "Ação"));
        movie.setDirector("Christopher Nolan");
        movie.setTitle("Tenet");
        movie.setDescription("Armado apenas com uma palavra – Tenet – e lutando pela sobrevivência do " +
                "planeta, o Protagonista viaja pelo mundo penumbroso da espionagem internacional numa " +
                "missão que irá desvendar algo além do tempo real. Não se trata de uma viagem no tempo. " +
                "Mas sim, uma inversão.");
        try {
            movie.setReleaseDate((Date) formatter.parse("2020-09-10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        list.add(movie);
        movie = new Movie();
        movie.setPopularity(227.879);
        movie.setDirector("Sam Mendes");
        movie.setTitle("1917");
        try {
            movie.setReleaseDate((Date) formatter.parse("2020-01-23"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        movie.setCategory(new Category(10752, "Guerra"));
        movie.setBackdropPath("cqa3sa4c4jevgnEJwq3CMF8UfTG.jpg");
        movie.setDescription("No auge da Primeira Guerra Mundial, dois jovens soldados britânicos, " +
                "Schofield e Blake, recebem uma missão aparentemente impossível. Numa corrida " +
                "contra o tempo, têm de atravessar território inimigo e entregar uma mensagem que " +
                "impedirá um ataque letal contra centenas de soldados, entre eles o irmão de Blake.");
        movie.setPosterPath("KkyXE7Hd9MPOOkORxkMM6SUXAB.jpg");
        list.add(movie);
        movie = new Movie();
        movie.setPopularity(246.499);
        movie.setPosterPath("jsi2UM64Mhr6NmY1LKeeCuZOaCo.jpg");
        movie.setBackdropPath("xFxk4vnirOtUxpOEWgA1MCRfy6J.jpg");
        movie.setCategory(new Category(12, "Aventura"));
        movie.setDirector("Dan Scanlon");
        movie.setTitle("Bora Lá");
        movie.setDescription("Num mundo de fantasia urbano, dois irmãos elfos adolescentes, Ian e " +
                "Barley Lightfoot, embarcam numa aventura para descobrir se ainda resta um pouco de " +
                "magia para passar um último dia com o pai que morreu quando eles eram muito novos.");
        try {
            movie.setReleaseDate((Date) formatter.parse("2020-03-05"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        list.add(movie);
        movie = new Movie();
        movie.setPopularity(226.958);
        movie.setPosterPath("roRRTAzpLJSo32jRGPDuUKZDfC.jpg");
        movie.setBackdropPath("x3NqAzuTWvnron4pXXyFGkyTFo7.jpg");
        movie.setCategory(new Category(18, "Drama"));
        movie.setDirector("Charlie Kaufman");
        movie.setTitle("Tudo Acaba Agora");
        movie.setDescription("Nada é o que parece quando uma mulher vai com o novo namorado, em relação " +
                "ao qual tem algumas reservas, para a quinta remota dos pais dele.");
        try {
            movie.setReleaseDate((Date) formatter.parse("2020-09-04"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        list.add(movie);
        movie = new Movie();
        movie.setPopularity(226.544);
        movie.setDirector("Anthony Russo & Joe Russo");
        movie.setTitle("Vingadores: Guerra do Infinito");
        try {
            movie.setReleaseDate((Date) formatter.parse("2018-04-26"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        movie.setCategory(new Category(12, "Aventura"));
        movie.setBackdropPath("bOGkgRGdhrBYJSLpXaxhXVstddV.jpg");
        movie.setDescription("Após 10 anos de uma viagem cinematográfica sem precedentes e que abrange " +
                "todo o universo cinematográfico Marvel, \"Vingadores: Guerra do Infinito\" traz ao " +
                "grande ecrã o maior confronto de todos os tempos. Os Vingadores e os seus aliados " +
                "Super-Heróis devem estar dispostos a sacrificar tudo para tentarem derrotar o " +
                "poderoso Thanos antes que o seu ataque de devastação e ruína acabe com o universo.");
        movie.setPosterPath("QTZmn34iwXYeCpVxhC9UrT8sX.jpg");
        list.add(movie);
        movie = new Movie();
        movie.setPopularity(215.412);
        movie.setPosterPath("g6n7TdQSgozArIM0okXTjjCM9Np.jpg");
        movie.setBackdropPath("xJWPZIYOEFIjZpBL7SVBGnzRYXp.jpg");
        movie.setCategory(new Category(12, "Aventura"));
        movie.setDirector("Chris Buck & Jennifer Lee");
        movie.setTitle("Frozen 2 - O Reino Gelado");
        movie.setDescription("Porque será que Elsa nasceu com poderes mágicos? A resposta está a " +
                "atormentá-la e a ameaçar o seu reino. Juntamente com Anna, Kristoff, Olaf e Sven, " +
                "ela parte numa perigosa e memorável aventura. Em \"Frozen\", Elsa temia que os " +
                "seus poderes fossem demais para o mundo, em \"Frozen 2\" espera que sejam " +
                "suficientes.");
        try {
            movie.setReleaseDate((Date) formatter.parse("2020-01-02"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        list.add(movie);
        movie = new Movie();
        movie.setPopularity(207.718);
        movie.setPosterPath("oUafkafJiFKkXuzROaAY8N9gGq.jpg");
        movie.setBackdropPath("wO5QSWZPBT71gMLvrRex0bVc0V9.jpg");
        movie.setCategory(new Category(35, "Comédia"));
        movie.setDirector("Vince Marcello");
        movie.setTitle("A Banca dos Beijos 2");
        movie.setDescription("Com a ida para a faculdade no horizonte, Elle tem de tomar decisões e " +
                "lidar com o namoro à distância com Noah, a amizade com Lee e os seus sentimentos " +
                "por um novo colega.");
        try {
            movie.setReleaseDate((Date) formatter.parse("2020-07-24"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        list.add(movie);
        movie = new Movie();
        movie.setPopularity(209.768);
        movie.setPosterPath("DS1Xh1dxfrR1H0sqATPxkwWFzi.jpg");
        movie.setBackdropPath("R6cvRtZgsYCkh8UFuWFN33xBP4.jpg");
        movie.setCategory(new Category(28, "Ação"));
        movie.setDirector("Sam Hargrave");
        movie.setTitle("Tyler Rake: Operação de Resgate");
        movie.setDescription("A missão de um mercenário empedernido torna-se uma luta pela sobrevivência " +
                "e pela própria alma quando é enviado ao Bangladeche para resgatar o filho de um " +
                "barão da droga.");
        try {
            movie.setReleaseDate((Date) formatter.parse("2020-04-24"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        list.add(movie);

        return list;
    }
}
