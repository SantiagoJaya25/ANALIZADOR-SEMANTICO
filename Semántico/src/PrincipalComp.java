
import java.io.*;
class PrincipalComp implements AnalisisConstantes {
        public static void main( String[] args )throws ParseException, Exception
        {
                try
                {
                    File file = new File("code.txt");
                        BufferedReader elementEntrada;

                        elementEntrada = new BufferedReader(new FileReader(file));

                PrincipalComp analiz = new PrincipalComp(elementEntrada) ;
                        analiz.Programa();
                        System.out.println("\u005ctANALISIS TERMINADO.");

                }
                catch(ParseException a)
                {
                        System.out.println(a.getMessage());
                        System.out.println("\u005ctANALISIS TERMINADO.");
                }

                AsiganaciondeTokens.visualizarTablas();
        }

  static final public void Programa() throws ParseException {
    jj_consume_token(PROGRAMA);
    jj_consume_token(IDENTIFICADOR);
    jj_consume_token(LLAVEIZQ);
    Cuerpo();
    jj_consume_token(LLAVEDER);
    jj_consume_token(0);
  }

  static final public void Cuerpo() throws ParseException {
  AsiganaciondeTokens.SetTables();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INT:
      case FLOAT:
      case CHAR:
      case STRING:
      case BOOL:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      variablesGlob();
    }
    Principal();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INT:
      case FLOAT:
      case CHAR:
      case STRING:
      case BOOL:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
      ImplementacionFunciones();
    }
  }

  static final public void variablesGlob() throws ParseException {
    var();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CORIZQ:
      vector();
      break;
    case PUNTOYCOMA:
    case COMA:
      declare();
      break;
    case PARIZQ:
      funcion();
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void vector() throws ParseException {
    jj_consume_token(CORIZQ);
    jj_consume_token(NUMERO);
    jj_consume_token(CORDER);
    jj_consume_token(PUNTOYCOMA);
  }

  static final public void declare() throws ParseException {
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMA:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_3;
      }
      jj_consume_token(COMA);
      jj_consume_token(IDENTIFICADOR);
    }
    jj_consume_token(PUNTOYCOMA);
  }

//declaracion de las Funciones
  static final public void funcion() throws ParseException {
    jj_consume_token(PARIZQ);
    parametros();
    jj_consume_token(PARDER);
    jj_consume_token(PUNTOYCOMA);
  }

  static final public void var() throws ParseException {
  int toke;
  Token valor;
    TiposDatos();
          toke = token.kind;
    jj_consume_token(DOSPUNTOS);
    valor = jj_consume_token(IDENTIFICADOR);
                AsiganaciondeTokens.InsertarSimbolo(valor, toke);
  }

  static final public void parametros() throws ParseException {
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMA:
      case INT:
      case FLOAT:
      case CHAR:
      case STRING:
      case BOOL:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_4;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INT:
      case FLOAT:
      case CHAR:
      case STRING:
      case BOOL:
        var();
        break;
      case COMA:
        jj_consume_token(COMA);
        var();
        break;
      default:
        jj_la1[5] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

//definicin de main
  static final public void Principal() throws ParseException {
    jj_consume_token(MAIN);
    jj_consume_token(LLAVEIZQ);
    Sentencias();
    jj_consume_token(LLAVEDER);
  }

  static final public void TiposDatos() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
      jj_consume_token(INT);
      break;
    case FLOAT:
      jj_consume_token(FLOAT);
      break;
    case STRING:
      jj_consume_token(STRING);
      break;
    case CHAR:
      jj_consume_token(CHAR);
      break;
    case BOOL:
      jj_consume_token(BOOL);
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

// funciones
  static final public void ImplementacionFunciones() throws ParseException {
    cabecera();
    cuerpoFuncion();
  }

  static final public void cabecera() throws ParseException {
    TiposDatos();
    jj_consume_token(DOSPUNTOS);
    jj_consume_token(IDENTIFICADOR);
    jj_consume_token(PARIZQ);
    parametros();
    jj_consume_token(PARDER);
  }

  static final public void cuerpoFuncion() throws ParseException {
    jj_consume_token(LLAVEIZQ);
    Sentencias();
    jj_consume_token(LLAVEDER);
  }

  static final public void VariablesLocales() throws ParseException {
        int td;
        Token var;
    TiposDatos();
          td = token.kind;
    jj_consume_token(DOSPUNTOS);
    var = jj_consume_token(IDENTIFICADOR);
                AsiganaciondeTokens.InsertarSimbolo(var, td);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IGUAL:
      VariablesAsignacion(var);
      break;
    default:
      jj_la1[7] = jj_gen;
      ;
    }
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMA:
        ;
        break;
      default:
        jj_la1[8] = jj_gen;
        break label_5;
      }
      jj_consume_token(COMA);
      var = jj_consume_token(IDENTIFICADOR);
                        AsiganaciondeTokens.InsertarSimbolo(var, td);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IGUAL:
        VariablesAsignacion(var);
        break;
      default:
        jj_la1[9] = jj_gen;
        ;
      }
    }
    jj_consume_token(PUNTOYCOMA);
    VS();
  }

  static final public void VariablesAsignacion(Token v1) throws ParseException {
        Token v2;
        Token v3;
        String res;
        boolean imp = false;
    jj_consume_token(IGUAL);
    TiposAsignaciones();
                v2 = token;
                res = AsiganaciondeTokens.checkAsing(v1, v2);

                if(res != " ")
                {
                        System.out.println(res);
                        imp = true;
                }
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MAS:
      case MENOS:
      case POR:
      case DIVIDE:
      case NUMERO:
      case IDENTIFICADOR:
      case DECIMAL:
      case CADENA:
      case CARACTER:
        ;
        break;
      default:
        jj_la1[10] = jj_gen;
        break label_6;
      }
      OpAritmetico();
      TiposAsignaciones();
                v3 = token;
                res = AsiganaciondeTokens.checkAsing(v1, v3);

                if(res != " " && !imp)
                {
                        System.out.println(res);
                }
    }
  }

  static final public void VS() throws ParseException {
    if (jj_2_1(3)) {
      VariablesLocales();
    } else {
      Sentencias();
    }
  }

  static final public void Sentencias() throws ParseException {
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case DO:
      case WRITE:
      case READ:
      case INT:
      case FLOAT:
      case CHAR:
      case STRING:
      case BOOL:
      case IDENTIFICADOR:
        ;
        break;
      default:
        jj_la1[11] = jj_gen;
        break label_7;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INT:
      case FLOAT:
      case CHAR:
      case STRING:
      case BOOL:
        VariablesLocales();
        break;
      case IF:
        SentenciaIf();
        break;
      case DO:
        SentenciaDo();
        break;
      default:
        jj_la1[12] = jj_gen;
        if (jj_2_2(2)) {
          SentenciaAsignacion();
          jj_consume_token(PUNTOYCOMA);
                                                        AsiganaciondeTokens.segunda = 0;
        } else {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case WRITE:
            SentenciaWrite();
            break;
          case READ:
            SentenciaRead();
            jj_consume_token(PUNTOYCOMA);
            break;
          default:
            jj_la1[13] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
        }
      }
    }
  }

//Sentencia IF
  static final public void SentenciaIf() throws ParseException {
    jj_consume_token(IF);
    jj_consume_token(PARIZQ);
    A();
    jj_consume_token(PARDER);
    jj_consume_token(THEN);
    jj_consume_token(LLAVEIZQ);
    Sentencias();
    jj_consume_token(LLAVEDER);
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ELSE:
        ;
        break;
      default:
        jj_la1[14] = jj_gen;
        break label_8;
      }
      Sino();
    }
  }

  static final public void Sino() throws ParseException {
    jj_consume_token(ELSE);
    jj_consume_token(LLAVEIZQ);
    Sentencias();
    jj_consume_token(LLAVEDER);
  }

  static final public void A() throws ParseException {
    Comparaciones();
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OR:
      case AND:
      case NUMERO:
      case IDENTIFICADOR:
        ;
        break;
      default:
        jj_la1[15] = jj_gen;
        break label_9;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OR:
      case AND:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case AND:
          jj_consume_token(AND);
          break;
        case OR:
          jj_consume_token(OR);
          break;
        default:
          jj_la1[16] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[17] = jj_gen;
        ;
      }
      Comparaciones();
    }
  }

//Fin sentencia if
  static final public void Comparaciones() throws ParseException {
    Valor();
    Operadores();
    Valor();
  }

  static final public void Valor() throws ParseException {
    if (jj_2_3(2)) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFICADOR:
        jj_consume_token(IDENTIFICADOR);
        break;
      case NUMERO:
        jj_consume_token(NUMERO);
        break;
      default:
        jj_la1[18] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUMERO:
      case IDENTIFICADOR:
        Expresion();
        break;
      default:
        jj_la1[19] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void Expresion() throws ParseException {
    if (jj_2_4(2)) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUMERO:
        jj_consume_token(NUMERO);
        break;
      case IDENTIFICADOR:
        jj_consume_token(IDENTIFICADOR);
        break;
      default:
        jj_la1[20] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUMERO:
      case IDENTIFICADOR:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case IDENTIFICADOR:
          jj_consume_token(IDENTIFICADOR);
          break;
        case NUMERO:
          jj_consume_token(NUMERO);
          break;
        default:
          jj_la1[21] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        OpAritmetico();
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case IDENTIFICADOR:
          jj_consume_token(IDENTIFICADOR);
          break;
        case NUMERO:
          jj_consume_token(NUMERO);
          break;
        default:
          jj_la1[22] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[23] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void Operadores() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IGUALIGUAL:
      jj_consume_token(IGUALIGUAL);
      break;
    case MENORIGUAL:
      jj_consume_token(MENORIGUAL);
      break;
    case MAYORIGUAL:
      jj_consume_token(MAYORIGUAL);
      break;
    case DIFERENTE:
      jj_consume_token(DIFERENTE);
      break;
    case MAYOR:
      jj_consume_token(MAYOR);
      break;
    case MENOR:
      jj_consume_token(MENOR);
      break;
    default:
      jj_la1[24] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public int OpAritmetico() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MAS:
      jj_consume_token(MAS);
                  {if (true) return 1;}
      break;
    case MENOS:
      jj_consume_token(MENOS);
                    {if (true) return 1;}
      break;
    case POR:
      jj_consume_token(POR);
                  {if (true) return 1;}
      break;
    case DIVIDE:
      jj_consume_token(DIVIDE);
                     {if (true) return 1;}
      break;
    default:
      jj_la1[25] = jj_gen;
            {if (true) return 0;}
         {if (true) return 0;}
    }
    throw new Error("Missing return statement in function");
  }

//Sentencia DO
  static final public void SentenciaDo() throws ParseException {
    jj_consume_token(DO);
    jj_consume_token(LLAVEIZQ);
    Sentencias();
    jj_consume_token(LLAVEDER);
    jj_consume_token(WHILE);
    jj_consume_token(PARIZQ);
    Comparaciones();
    jj_consume_token(PARDER);
    jj_consume_token(PUNTOYCOMA);
  }

//Sentencia WHILE
  static final public void SentenciaWhile() throws ParseException {
    jj_consume_token(WHILE);
    jj_consume_token(PARIZQ);
    Comparaciones();
    jj_consume_token(PARDER);
    jj_consume_token(DO);
    jj_consume_token(LLAVEIZQ);
    Sentencias();
    jj_consume_token(LLAVEDER);
  }

//Sentencia ASIGNACION
  static final public void SentenciaAsignacion() throws ParseException {
        Token valor1;
        Token valor2;
        Token valor3;
        int aux;
        String resultado;
        boolean imp = false;
    valor1 = jj_consume_token(IDENTIFICADOR);
    jj_consume_token(IGUAL);
    TiposAsignaciones();
    valor2 = token;
        resultado = AsiganaciondeTokens.checkAsing(valor1, valor2);

        if(resultado != " ")
        {
                System.out.println(resultado);
                imp = true;
        }
    label_10:
    while (true) {
      if (jj_2_5(2)) {
        ;
      } else {
        break label_10;
      }
      OpAritmetico();
      TiposAsignaciones();
    valor3 = token;
        resultado = AsiganaciondeTokens.checkAsing(valor1, valor3);

        if(resultado != " " && !imp)
        {
                System.out.println(resultado);
        }
    }
  }

  static final public void TiposAsignaciones() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFICADOR:
      jj_consume_token(IDENTIFICADOR);
      break;
    case NUMERO:
      jj_consume_token(NUMERO);
      break;
    case DECIMAL:
      jj_consume_token(DECIMAL);
      break;
    case CADENA:
      jj_consume_token(CADENA);
      break;
    case CARACTER:
      jj_consume_token(CARACTER);
      break;
    default:
      jj_la1[26] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

//Sentencia WRITE
  static final public void SentenciaWrite() throws ParseException {
    jj_consume_token(WRITE);
    jj_consume_token(PARIZQ);
    label_11:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUMERO:
      case IDENTIFICADOR:
      case CADENA:
        ;
        break;
      default:
        jj_la1[27] = jj_gen;
        break label_11;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUMERO:
      case IDENTIFICADOR:
        Expresion();
        label_12:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case MAS:
            ;
            break;
          default:
            jj_la1[28] = jj_gen;
            break label_12;
          }
          jj_consume_token(MAS);
          jj_consume_token(CADENA);
        }
        break;
      case CADENA:
        jj_consume_token(CADENA);
        label_13:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case MAS:
            ;
            break;
          default:
            jj_la1[29] = jj_gen;
            break label_13;
          }
          jj_consume_token(MAS);
          Expresion();
        }
        break;
      default:
        jj_la1[30] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    jj_consume_token(PARDER);
    jj_consume_token(PUNTOYCOMA);
  }

//Sentencia READ
  static final public void SentenciaRead() throws ParseException {
    jj_consume_token(READ);
    jj_consume_token(PARIZQ);
    jj_consume_token(PARDER);
  }

  static private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  static private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  static private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  static private boolean jj_2_5(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_5(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  static private boolean jj_3_2() {
    if (jj_3R_15()) return true;
    return false;
  }

  static private boolean jj_3R_15() {
    if (jj_scan_token(IDENTIFICADOR)) return true;
    if (jj_scan_token(IGUAL)) return true;
    return false;
  }

  static private boolean jj_3R_23() {
    return false;
  }

  static private boolean jj_3R_14() {
    if (jj_3R_18()) return true;
    if (jj_scan_token(DOSPUNTOS)) return true;
    if (jj_scan_token(IDENTIFICADOR)) return true;
    return false;
  }

  static private boolean jj_3R_22() {
    if (jj_scan_token(DIVIDE)) return true;
    return false;
  }

  static private boolean jj_3R_21() {
    if (jj_scan_token(POR)) return true;
    return false;
  }

  static private boolean jj_3R_18() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(40)) {
    jj_scanpos = xsp;
    if (jj_scan_token(41)) {
    jj_scanpos = xsp;
    if (jj_scan_token(43)) {
    jj_scanpos = xsp;
    if (jj_scan_token(42)) {
    jj_scanpos = xsp;
    if (jj_scan_token(44)) return true;
    }
    }
    }
    }
    return false;
  }

  static private boolean jj_3_1() {
    if (jj_3R_14()) return true;
    return false;
  }

  static private boolean jj_3R_20() {
    if (jj_scan_token(MENOS)) return true;
    return false;
  }

  static private boolean jj_3R_19() {
    if (jj_scan_token(MAS)) return true;
    return false;
  }

  static private boolean jj_3_4() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(45)) {
    jj_scanpos = xsp;
    if (jj_scan_token(46)) return true;
    }
    return false;
  }

  static private boolean jj_3R_16() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_19()) {
    jj_scanpos = xsp;
    if (jj_3R_20()) {
    jj_scanpos = xsp;
    if (jj_3R_21()) {
    jj_scanpos = xsp;
    if (jj_3R_22()) {
    jj_scanpos = xsp;
    if (jj_3R_23()) return true;
    }
    }
    }
    }
    return false;
  }

  static private boolean jj_3_3() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(46)) {
    jj_scanpos = xsp;
    if (jj_scan_token(45)) return true;
    }
    return false;
  }

  static private boolean jj_3R_17() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(46)) {
    jj_scanpos = xsp;
    if (jj_scan_token(45)) {
    jj_scanpos = xsp;
    if (jj_scan_token(47)) {
    jj_scanpos = xsp;
    if (jj_scan_token(48)) {
    jj_scanpos = xsp;
    if (jj_scan_token(49)) return true;
    }
    }
    }
    }
    return false;
  }

  static private boolean jj_3_5() {
    if (jj_3R_16()) return true;
    if (jj_3R_17()) return true;
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public compTokenManager token_source;
  static AnalisisCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[31];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x0,0x0,0xd100000,0x8000000,0x8000000,0x8000000,0x0,0x2,0x8000000,0x2,0x3c,0x69000,0x9000,0x60000,0x4000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x3c,0x0,0x0,0x4,0x4,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x1f00,0x1f00,0x0,0x0,0x1f00,0x1f00,0x1f00,0x0,0x0,0x0,0x3e000,0x5f00,0x1f00,0x0,0x0,0x60c0,0xc0,0xc0,0x6000,0x6000,0x6000,0x6000,0x6000,0x6000,0x3f,0x0,0x3e000,0x16000,0x0,0x0,0x16000,};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[5];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public PrincipalComp(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public PrincipalComp(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new AnalisisCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new compTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 31; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 31; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public PrincipalComp(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new AnalisisCharStream(stream, 1, 1);
    token_source = new compTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 31; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 31; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public PrincipalComp(compTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 31; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(compTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 31; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[59];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 31; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 59; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 5; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
            case 4: jj_3_5(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
