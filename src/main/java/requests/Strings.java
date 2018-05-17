package requests;

public class Strings {
    
    
    //URLS
    public static String URL_CETESB = "http://cetesb.sp.gov.br/";
    public static String URL_CETESB_HISTORICO = "http://cetesb.sp.gov.br/historico/";
    public static String URL_CETESB_PERGUNTAS_FREQUENTES = "http://cetesb.sp.gov.br/perguntas-frequentes/";
    public static String URL_CETESB_LICITACOES = "http://licitacoes.cetesb.sp.gov.br/Licitacoes/Editais";
    public static String URL_CETESB_NEWS = "http://cetesb.sp.gov.br/blog/category/noticias-cetesb/";
//    public static String URL_INSTITUCIONAL = "";
//    public static String URL_INSTITUCIONAL = "";
    
    //html
    public static String INICIO_HTML = "<html>\n <head>\n<title>Título da página</title>\n<meta charset=\"utf-8\">\n</head>\n<body>";
    public static String FIM_HTML = "</body>\n</html>";
    
    //substituir no html inicial
    
    public static String INICIO_CETESB_HISTORICO = "<p><img class=\"alignleft size-full wp-image-130 colorbox-1054\" style=\"border: 0px;";
    public static String FIM_CETESB_HISTORICO = "</div><!-- .entry-content -->";
    
    public static String INICIO_PERGUNTAS_FREQUENTES = "<span class=\"vc_tta-title-text\">";
    public static String FIM_PERGUNTAS_FREQUENTES = "</div></div></div></div></div></div></div></div></div></div>";

   public static String INICIO_CETESB_LICITACOES = "<a class=\"navbar-brand\" href=\"/\">Editais</a>";
   public static String FIM_CETESB_LICITACOES = "<script src=" + 
   		"";
   
   public static String INICIO_NEWS_URL = "<font color=\"#206197\">Cadastro de Forn";
   public static String FIM_NEWS_URL = "<table border=\"1\" c";
   
   public static String INICIO_NEWS = "<div class=\"entry-content\">";
   public static String FIM_NEWS = "</div><!-- .entry-content -->";
   
   public static String SOBRE = INICIO_HTML + "<h1><span style=\"color:#FF0000\">Tiete Chat News</span></h1>\n" +
"\n" +
"<p>&nbsp;</p>\n" +
"\n" +
"<p><span style=\"font-family:comic sans ms,cursive\">Criado por Leandro Shiniti Tacara</span></p>\n" +
"\n" +
"<p><span style=\"font-family:comic sans ms,cursive\">14/02/18</span></p>\n" +
"\n" +
"<p><span style=\"font-family:comic sans ms,cursive\">Aproveite!</span></p>" + FIM_HTML;
}
