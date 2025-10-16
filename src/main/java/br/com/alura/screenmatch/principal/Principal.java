package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.repository.SerieRepository;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "http://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";      //key alura
    private List<DadosSerie> dadosSeries = new ArrayList<>();

    //Manter a linha abaixo comentada.
    //@Autowired
    private SerieRepository repositorio;

    private List<Serie> series = new ArrayList<>();

    public Principal(SerieRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {
        var opcao = -1;
        while(opcao != 0) {
            var menu = """
                    1 - Buscar Séries
                    2 - Buscar Episódios
                    3 - Listar Séries Buscadas
                    
                    0 - Sair                                 
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodioPorSerie();
                    break;
                case 3:
                    listarSeriesBuscadas();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void buscarSerieWeb() {
        DadosSerie dados = getDadosSerie();
        Serie serie = new Serie(dados); //Comentar esse linha para não savar no db
        //dadosSeries.add(dados); //Comentar quando for salvar no DB.
        repositorio.save(serie); //Comentar esse linha para não savar no db//Comentar esse linha para não savar no db
        System.out.println(dados);
    }

    private DadosSerie getDadosSerie() {
        System.out.println("Digite o nome da série para busca");
        var nomeSerie = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        return dados;
    }

    private void buscarEpisodioPorSerie(){
        //Linha abaixo comentada, é utilizada quando nao for pesquisar na lista. Ou seja não no banco.
        //DadosSerie dadosSerie = getDadosSerie();
        listarSeriesBuscadas();
        System.out.println("Escolha uma séria pelo nome:");
        var nomeserie = leitura.nextLine();
        //asr parei aqui. 05:40 hs
        Optional<Serie> serie = series.stream()
                .filter(s -> s.getTitulo().toLowerCase().contains(nomeserie.toLowerCase()))
                .findFirst();
        if(serie.isPresent()) {

            var serieEncontrada = serie.get();
            List<DadosTemporada> temporadas = new ArrayList<>();

            for (int i = 1; i <= serieEncontrada.getTotalTemporadas(); i++) {
                var json = consumo.obterDados(ENDERECO + serieEncontrada.getTitulo().replace(" ", "+") + "&season=" + i + API_KEY);
                DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
                temporadas.add(dadosTemporada);
            }
            temporadas.forEach(System.out::println);

            //List<Episodio> episodios = temporadas.stream()
            List<Episodio> episodios = temporadas.stream()
                    .flatMap(d -> d.episodios().stream()
                            .map(e -> new Episodio(d.numero(), e)))
                    .collect(Collectors.toList());

            serieEncontrada.setEpisodios(episodios);
            repositorio.save(serieEncontrada);
        } else {
            System.out.println("Série não encontrada!");
        }
    }

    private void listarSeriesBuscadas() {
        //List<Serie> series = new ArrayList<>();

//Linhas abaixo devem ser descomentadas para quando for para exibir as serés sem o banco de dados.
//        series = dadosSeries.stream()
//                        .map(d -> new Serie(d))
//                               .collect(Collectors.toList());

        //Linha abaixo para listra o que esta no BD
        //Linha abaixo comentada, é utilizada quando nao for pesquisar na lista. Ou seja não no banco.
        //List<Serie> series = repositorio.findAll();

        //Linhas abaixo para buscar os episódis na serie selecionada.
        series = repositorio.findAll();

        series.stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);
    }

}

