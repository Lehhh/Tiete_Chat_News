package requests;

public class Strings {
    
    
    //URLS
    public static String URL_DAEE = "http://www.daee.sp.gov.br";
    public static String URL_LICITACOES = "http://www.daee.sp.gov.br/index.php?option=com_content&view=article&id=74:licitacao&catid=45:licitacao";
    public static String URL_CADASTROFORNECEDOR = "http://www.daee.sp.gov.br/index.php?option=com_content&view=article&id=75:cadastro-de-fornecedores&catid=45:licitacao";
    public static String URL_INSTITUCIONAL = "http://www.daee.sp.gov.br/index.php?option=com_content&view=article&id=50&Itemid=29";
    public static String URL_NEWS = "http://www.daee.sp.gov.br/index.php?option=com_content&view=category&layout=blog&id=48&Itemid=53";
//    public static String URL_INSTITUCIONAL = "";
//    public static String URL_INSTITUCIONAL = "";
    
    //html
    public static String INICIO_HTML = "<html>\n <head>\n<title>Título da página</title>\n<meta charset=\"utf-8\">\n</head>\n<body>";
    public static String FIM_HTML = "</body>\n</html>";
    
    //substituir no html inicial
    
    public static String INICIO_LICITACOES = "<u>Avisos e Resultados d";
    public static String FIM_LICITACOES = "<p align=\"center\">e-mail:";
    
    public static String INICIO_CADASTROFORNECEDOR = "<font color=\"#206197\">Cadastro de Forn";
    public static String FIM_CADASTROFORNECEDOR = "<table border=\"1\" c";

   public static String INICIO_INSTITUICIONAL = "<br />O Departamento de";
   public static String FIM_INSTITUICIONAL = "<div class=\"jwts_title\">";
   
   public static String INICIO_NEWS_URL = "<font color=\"#206197\">Cadastro de Forn";
   public static String FIM_NEWS_URL = "<table border=\"1\" c";
   
   public static String INICIO_NEWS = "<h2 class=\"art-postheader\">";
   public static String FIM_NEWS = "<hr>Adicione esta";
   
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
