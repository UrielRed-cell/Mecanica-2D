package com.roboticadomestica;
//Notas usar css,sv//Notas usar css,svgg
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import com.roboticadomestica.interfaz.Animacion;

public class Main extends Application {
    private Animacion animacion;
    @Override
    public void start(Stage primaryStage) {
        //Declaracion de variables
        BorderPane borderPane= new BorderPane();
        //Parents
        VBox vBoxMenu=new VBox();
        VBox vBoxPanel1=new VBox();
        VBox vBoxBottom1=new VBox();
        VBox vBoxBottom2=new VBox();
        VBox vBoxPanel3=new VBox();
        HBox hBox=new HBox();
        HBox hBoxFiguras1=new HBox();
        HBox hBoxFiguras2=new HBox();
        HBox hBoxFiguras3=new HBox();
        HBox hBoxFiguras4=new HBox();
        HBox hBoxFiguras5=new HBox();
        HBox hBoxFiguras6=new HBox();
        HBox hBoxFiguras7=new HBox();
        HBox hBoxFiguras8=new HBox();
        HBox hBoxFiguras9=new HBox();
        HBox hBoxFiguras10=new HBox();
        HBox hBoxBottom=new HBox();
        GridPane gridPane=new GridPane();
        //Constrains
        RowConstraints rowConstraintsTop=new RowConstraints();
        RowConstraints rowConstraintsBottom=new RowConstraints();
        rowConstraintsTop.setPercentHeight(80);
        rowConstraintsBottom.setPercentHeight(20);
        ColumnConstraints columnConstraints=new ColumnConstraints();
        columnConstraints.setPercentWidth(50);
        //Menus
        //Menu Bar
        MenuBar menuBar=new MenuBar();
        MenuBar menuBarImg=new MenuBar();
        //Menu
        Menu menuArchivo = new Menu("Archivo");
		Menu menuFisicas = new Menu("Fisicas");
		Menu menuEcuaciones = new Menu("Ecuaciones");
		Menu menuVista = new Menu("Vista");
		Menu menuAyuda = new Menu("Ayuda");
		Menu menuDonar = new Menu("Donar");
        //Submenus
        Menu menuNuevo = new Menu("Nuevo");
		Menu menuAbrir = new Menu("Abrir");
		Menu menuSalvar = new Menu("Salvar");
		Menu menuSimulacion = new Menu("Simulación");
		Menu menuMostrarVectores = new Menu("Mostrar");
		Menu menuUnidades = new Menu("Unidades");
		Menu menuColores = new Menu("Colores");
		Menu menuAspecto = new Menu("Aspecto");
		//Menu de imagenes
        //----
		Menu menuImgEjecutar = new Menu();
        Image imgEjecutar = new Image(getClass().getClassLoader().getResourceAsStream("imagenes/ejecutar.png"));
        ImageView imgVEjecutar = new ImageView(imgEjecutar);
        imgVEjecutar.setFitWidth(22);
        imgVEjecutar.setFitHeight(22);
        menuImgEjecutar.setGraphic(imgVEjecutar);
		//----
        Menu menuImgPausa = new Menu();
        Image imgPausar = new Image(getClass().getClassLoader().getResourceAsStream("imagenes/pausar.png"));
        ImageView imgVPausar = new ImageView(imgPausar);
        imgVPausar.setFitWidth(16);
        imgVPausar.setFitHeight(16);
        menuImgPausa.setGraphic(imgVPausar);
        //----
		Menu menuImgDetener = new Menu();
        Image imgDetener = new Image(getClass().getClassLoader().getResourceAsStream("imagenes/detener.png"));
        ImageView imgVDetener = new ImageView(imgDetener);
        imgVDetener.setFitWidth(16);
        imgVDetener.setFitHeight(16);
        menuImgDetener.setGraphic(imgVDetener);
		//----
        Menu menuImgReiniciar = new Menu();
		Image imgReiniciar = new Image(getClass().getClassLoader().getResourceAsStream("imagenes/reiniciar.png"));
        ImageView imgVReiniciar = new ImageView(imgReiniciar);
        imgVReiniciar.setFitWidth(16);
        imgVReiniciar.setFitHeight(16);
        menuImgReiniciar.setGraphic(imgVReiniciar);
        //----
        Menu menuImgMover = new Menu();
		Image imgMover = new Image(getClass().getClassLoader().getResourceAsStream("imagenes/mover.png"));
        ImageView imgVMover = new ImageView(imgMover);
        imgVMover.setFitWidth(16);
        imgVMover.setFitHeight(16);
        menuImgMover.setGraphic(imgVMover);
        //----
        Menu menuImgSeleccionar = new Menu();
		Image imgSeleccionar = new Image(getClass().getClassLoader().getResourceAsStream("imagenes/seleccionar.png"));
        ImageView imgVSeleccionar = new ImageView(imgSeleccionar);
        imgVSeleccionar.setFitWidth(16);
        imgVSeleccionar.setFitHeight(16);
        menuImgSeleccionar.setGraphic(imgVSeleccionar);
        //----
        Menu menuImgPuntero = new Menu();
		Image imgPuntero = new Image(getClass().getClassLoader().getResourceAsStream("imagenes/puntero.png"));
        ImageView imgVPuntero = new ImageView(imgPuntero);
        imgVPuntero.setFitWidth(16);
        imgVPuntero.setFitHeight(16);
        menuImgPuntero.setGraphic(imgVPuntero);
        //----
        Menu menuImgTexto = new Menu();
	    Image imgTexto = new Image(getClass().getClassLoader().getResourceAsStream("imagenes/texto.png"));
        ImageView imgVTexto = new ImageView(imgTexto);
        imgVTexto.setFitWidth(16);
        imgVTexto.setFitHeight(16);
        menuImgTexto.setGraphic(imgVTexto);	
        //----
        Menu menuImgBorrar = new Menu();
		Image imgBorrar = new Image(getClass().getClassLoader().getResourceAsStream("imagenes/borrar.png"));
        ImageView imgVBorrar = new ImageView(imgBorrar);
        imgVBorrar.setFitWidth(16);
        imgVBorrar.setFitHeight(16);
        menuImgBorrar.setGraphic(imgVBorrar);
        //MenuItem
		//Menu Archivo
		//--Submenu--Nuevo
		MenuItem menuBlanco=new MenuItem("Archivo blanco");
        MenuItem menuScript=new MenuItem("Script");
        MenuItem menuLibreria=new MenuItem("Libreria");
        MenuItem menuProyecto=new MenuItem("Proyecto");
        //--Submenu--Abrir
        MenuItem menuAbrirProyecto=new MenuItem("Proyecto");
        MenuItem menuFisc=new MenuItem("Archivo *.fisc");
        //--Submenu--Salvar
        MenuItem menuSalvarDoc=new MenuItem("Salvar ctrl+s");
        MenuItem menuSalvarComo=new MenuItem("Salvar como");
        //--SOLOS--
        MenuItem menuExportar=new MenuItem("Exportar");
        MenuItem menuSalir=new MenuItem("Salir");
        //Menu Fisicas
        //--Submenu--Simulacion
        MenuItem menuEjecutar=new MenuItem("Ejecutar ctrl+e");
        MenuItem menuPausa=new MenuItem("Pausa ctrl+p");
        MenuItem menuDetener=new MenuItem("Detener ctrl+d");
        MenuItem menuReiniciar=new MenuItem("Reiniciar ctrl+r");
        //SOLOS
		MenuItem menuParametrosMundo=new MenuItem("Parametros del mundo");
        MenuItem menuMarcoReferencia=new MenuItem("Marco de referencia");
      	//--Submenu--Mostrar Vectores
        MenuItem menuFuerzas=new MenuItem("Fuerzas");
        MenuItem menuVelocidades=new MenuItem("Velocidades");
        MenuItem menuAceleraciones=new MenuItem("Aceleraciones");
        MenuItem menuDesplazamientos=new MenuItem("Desplazamientos");
        //--Submenu--Unidades
        MenuItem menuSI=new MenuItem("Unidades SI");
        MenuItem menuCGS=new MenuItem("Unidades CGS");
        MenuItem menuUS=new MenuItem("Unidades US");
        //Menu Ecuaciones
        MenuItem menuMetodosNumericos=new MenuItem("Métodos numéricos");
        MenuItem menuMetodosSimbolicos=new MenuItem("Métodos simbolicos");
        MenuItem menuGraficas=new MenuItem("Gráficas");
        MenuItem menuObtenerEcuaciones=new MenuItem("Obtener ecuaciones");
        MenuItem menuGestionRecursos=new MenuItem("Gestión de recursos");
        //Menu Vista SOLOS
        MenuItem menuDeshacer=new MenuItem("Deshacer");
        MenuItem menuGirar=new MenuItem("Girar");
        MenuItem menuVerEjes=new MenuItem("Ver ejes");
        //Menu Ayuda SOLOS
        MenuItem menuAtajos=new MenuItem("Atajos");
        MenuItem menuVersiones=new MenuItem("Versiones");
        MenuItem menuTutorial=new MenuItem("Tutorial");
        MenuItem menuDocumentacion=new MenuItem("Documentación");
		//Configuracion Menus
        menuNuevo.getItems().addAll(menuBlanco,menuScript,menuLibreria,menuProyecto);
        menuAbrir.getItems().addAll(menuFisc,menuAbrirProyecto);
        menuSalvar.getItems().addAll(menuSalvarDoc,menuSalvarComo);
        menuArchivo.getItems().addAll(menuNuevo,menuAbrir,menuSalvar,menuExportar,menuSalir);
        menuSimulacion.getItems().addAll(menuEjecutar,menuPausa,menuDetener,menuReiniciar);  
  		menuMostrarVectores.getItems().addAll(menuFuerzas,menuVelocidades,
  		menuAceleraciones,menuDesplazamientos);        
        menuUnidades.getItems().addAll(menuSI,menuCGS,menuUS);
        menuFisicas.getItems().addAll(menuSimulacion,menuParametrosMundo,
         			menuMarcoReferencia,menuMostrarVectores,menuUnidades);
        menuEcuaciones.getItems().addAll(menuMetodosNumericos,menuMetodosSimbolicos,menuGraficas,
                menuObtenerEcuaciones,menuGestionRecursos);
        menuVista.getItems().addAll(menuColores,menuAspecto,menuDeshacer,menuGirar,menuVerEjes);
        menuAyuda.getItems().addAll(menuAtajos,menuVersiones,menuTutorial,menuDocumentacion);
        menuBar.getMenus().addAll(menuArchivo,menuFisicas,menuEcuaciones,menuVista,menuAyuda,menuDonar);
        menuBarImg.getMenus().addAll(menuImgEjecutar,menuImgPausa,menuImgDetener,menuImgReiniciar,
                menuImgMover,menuImgSeleccionar,menuImgPuntero,menuImgTexto,menuImgBorrar);
        vBoxMenu.getChildren().addAll(menuBar,menuBarImg);
        //Panel inferior
        Label lbTituloTraza=new Label("Traza de procesamiento");
        TextArea txtTrazaProcesamiento=new TextArea();
        txtTrazaProcesamiento.setEditable(false);
        vBoxBottom1.getChildren().addAll(lbTituloTraza,txtTrazaProcesamiento);
        Label lbTituloConsola=new Label("¡Consola!");
        TextArea txtConsola=new TextArea(">>");
        vBoxBottom2.getChildren().addAll(lbTituloConsola,txtConsola);
        hBoxBottom.getChildren().addAll(vBoxBottom1,vBoxBottom2);
        hBoxBottom.setId("hBoxBottom");
        //Panel2
        Canvas canvas = new Canvas (1100,450);
        GraphicsContext gc=canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE); // Establece el color de fondo en blanco
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight()); // Rellena el fondo del Canvas
        animacion=new Animacion(canvas,1100,450);
        //Accion Menu
        
        menuVerEjes.setOnAction(event->{
            animacion.ejes(true,2);
        });
        //Botones primera parte
        Button btnCirculo=new Button();
        Image imgCirculo = new Image(getClass().getClassLoader().getResourceAsStream("imagenes/circulo.png"));
        ImageView imgVCirculo = new ImageView(imgCirculo);
        imgVCirculo.setFitWidth(16);
        imgVCirculo.setFitHeight(16);
        btnCirculo.setGraphic(imgVCirculo);
        boolean[] circuloDibujado=new boolean[1];
        btnCirculo.setOnAction(event->{
            circuloDibujado[0]=false;
            txtTrazaProcesamiento.appendText("Dibujando circulo ...\n");
            animacion.dibujarCirculo(circuloDibujado);
        });
        Button btnCuadrilatero=new Button();
        Image imgCuadrilatero = new Image(getClass().getClassLoader().getResourceAsStream("imagenes/cuadrilatero.png"));
        ImageView imgVCuadrilatero = new ImageView(imgCuadrilatero);
        imgVCuadrilatero.setFitWidth(16);
        imgVCuadrilatero.setFitHeight(16);
        btnCuadrilatero.setGraphic(imgVCuadrilatero);
        boolean[] rectanguloDibujado=new boolean[1];
        btnCuadrilatero.setOnAction(event->{
            rectanguloDibujado[0]=false;
            txtTrazaProcesamiento.appendText("Dibujando rectangulo...\n");
            animacion.dibujarRectangulo(rectanguloDibujado);
        });
        Button btnIrregular=new Button();
        Image imgIrregular = new Image(getClass().getClassLoader().getResourceAsStream("imagenes/irregular.png"));
        ImageView imgVIrregular = new ImageView(imgIrregular);
        imgVIrregular.setFitWidth(16);
        imgVIrregular.setFitHeight(16);
        btnIrregular.setGraphic(imgVIrregular);
        btnIrregular.setOnAction(event->{
            System.out.println("El tres");
        });
        Button btnFxy=new Button();
        Image imgFuncion = new Image(getClass().getClassLoader().getResourceAsStream("imagenes/funcion.png"));
        ImageView imgVFuncion = new ImageView(imgFuncion);
        imgVFuncion.setFitWidth(16);
        imgVFuncion.setFitHeight(16);
        btnFxy.setGraphic(imgVFuncion);
        btnFxy.setOnAction(event->{
            System.out.println("El cuatro");
        });
        //Label
        Label lbSeparador1=new Label("");
        //Botones segunda parte
        Button btnAncla=new Button();
        Image imgAncla=new Image(getClass().getClassLoader().getResourceAsStream("imagenes/ancla.png"));
        ImageView imgVAncla=new ImageView(imgAncla);
        imgVAncla.setFitWidth(16);
        imgVAncla.setFitHeight(16);
        btnAncla.setGraphic(imgVAncla);
        btnAncla.setOnAction(event->{
            System.out.println("Ancla");
        });
        Button btnCota=new Button();
        Image imgCota=new Image(getClass().getClassLoader().getResourceAsStream("imagenes/cota.png"));
        ImageView imgVCota=new ImageView(imgCota);
        imgVCota.setFitWidth(16);
        imgVCota.setFitHeight(16);
        btnCota.setGraphic(imgVCota);
        btnCota.setOnAction(event->{
            System.out.println("Cota");
        });
        Button btnUnion=new Button();
        Image imgUnion=new Image(getClass().getClassLoader().getResourceAsStream("imagenes/union.png"));
        ImageView imgVUnion=new ImageView(imgUnion);
        imgVUnion.setFitWidth(16);
        imgVUnion.setFitHeight(16);
        btnUnion.setGraphic(imgVUnion);
        btnUnion.setOnAction(event->{
            System.out.println("Union");
        });
        Button btnBarra=new Button();
        Image imgBarra=new Image(getClass().getClassLoader().getResourceAsStream("imagenes/barra.png"));
        ImageView imgVBarra=new ImageView(imgBarra);
        imgVBarra.setFitWidth(16);
        imgVBarra.setFitHeight(16);
        btnBarra.setGraphic(imgVBarra); 
        btnBarra.setOnAction(event->{
            System.out.println("Barra");
        });
        Button btnBarraMoldeable=new Button();
        Image imgBarraMoldeable=new Image(getClass().getClassLoader().getResourceAsStream("imagenes/barramoldeable.png"));
        ImageView imgVBarraMoldeable=new ImageView(imgBarraMoldeable);
        imgVBarraMoldeable.setFitWidth(16);
        imgVBarraMoldeable.setFitHeight(16);
        btnBarraMoldeable.setGraphic(imgVBarraMoldeable);
        btnBarraMoldeable.setOnAction(event->{
            System.out.println("Moldeable");
        });
        Button btnSoldar=new Button();
        Image imgSoldar=new Image(getClass().getClassLoader().getResourceAsStream("imagenes/soldar.png"));
        ImageView imgVSoldar=new ImageView(imgSoldar);
        imgVSoldar.setFitWidth(16);
        imgVSoldar.setFitHeight(16);
        btnSoldar.setGraphic(imgVSoldar);
        btnSoldar.setOnAction(event->{
            System.out.println("Soldar");
        });
        //Label
        Label lbSeparador2=new Label("");
        //Botones tercera parte
        Button btnResorte=new Button();
        Image imgResorte=new Image(getClass().getClassLoader().getResourceAsStream("imagenes/resorte.png"));
        ImageView imgVResorte=new ImageView(imgResorte);
        imgVResorte.setFitWidth(16);
        imgVResorte.setFitHeight(16);
        btnResorte.setGraphic(imgVResorte);
        btnResorte.setOnAction(event->{
            System.out.println("Resorte");
        });
        Button btnAmortiguador=new Button();
        Image imgAmortiguador=new Image(getClass().getClassLoader().getResourceAsStream("imagenes/amortiguamiento.png"));
        ImageView imgVAmortiguador=new ImageView(imgAmortiguador);
        imgVAmortiguador.setFitWidth(16);
        imgVAmortiguador.setFitHeight(16);
        btnAmortiguador.setGraphic(imgVAmortiguador);
        btnAmortiguador.setOnAction(event->{
            System.out.println("Amortiguador");
        });
        Button btnMotor=new Button();
        Image imgMotor=new Image(getClass().getClassLoader().getResourceAsStream("imagenes/motor.png"));
        ImageView imgVMotor=new ImageView(imgMotor);
        imgVMotor.setFitWidth(16);
        imgVMotor.setFitHeight(16);
        btnMotor.setGraphic(imgVMotor);
        btnMotor.setOnAction(event->{
            System.out.println("Motor");
        });
        Button btnPolea=new Button();
        Image imgPolea=new Image(getClass().getClassLoader().getResourceAsStream("imagenes/polea.png"));
        ImageView imgVPolea=new ImageView(imgPolea);
        imgVPolea.setFitWidth(16);
        imgVPolea.setFitHeight(16);
        btnPolea.setGraphic(imgVPolea);
        btnPolea.setOnAction(event->{
            System.out.println("Polea");
        });
        Button btnCable=new Button();
        Image imgCable=new Image(getClass().getClassLoader().getResourceAsStream("imagenes/cable.png"));
        ImageView imgVCable=new ImageView(imgCable);
        imgVCable.setFitWidth(16);
        imgVCable.setFitHeight(16);
        btnCable.setGraphic(imgVCable);
        btnCable.setOnAction(event->{
            System.out.println("Cable");
        });
        //Label
        Label lbSeparador3=new Label("");
        //Botones 4 parte

        Button btnFuerza=new Button();
        Image imgFuerza=new Image(getClass().getClassLoader().getResourceAsStream("imagenes/fuerza.png"));
        ImageView imgVFuerza=new ImageView(imgFuerza);
        imgVFuerza.setFitWidth(16);
        imgVFuerza.setFitHeight(16);
        btnFuerza.setGraphic(imgVFuerza);
        btnFuerza.setOnAction(event->{
            System.out.println("Fuerza");
        });
        Button btnMomento=new Button();
        Image imgMomento=new Image(getClass().getClassLoader().getResourceAsStream("imagenes/momento.png"));
        ImageView imgVMomento=new ImageView(imgMomento);
        imgVMomento.setFitWidth(16);
        imgVMomento.setFitHeight(16);
        btnMomento.setGraphic(imgVMomento); 
        btnMomento.setOnAction(event->{
            System.out.println("Momento");
        });
        Button btnVelocidad=new Button();
        Image imgVelocidad=new Image(getClass().getClassLoader().getResourceAsStream("imagenes/velocidad.png"));
        ImageView imgVVelocidad=new ImageView(imgVelocidad);
        imgVVelocidad.setFitWidth(16);
        imgVVelocidad.setFitHeight(16);
        btnVelocidad.setGraphic(imgVVelocidad);
        btnVelocidad.setOnAction(event->{
            System.out.println("Velocidad");
        });
        Button btnFuerzaVariable=new Button();
        Image imgFVar=new Image(getClass().getClassLoader().getResourceAsStream("imagenes/fvariable.png"));
        ImageView imgVFVar=new ImageView(imgFVar);
        imgVFVar.setFitWidth(16);
        imgVFVar.setFitHeight(16);
        btnFuerzaVariable.setGraphic(imgVFVar);
        btnFuerzaVariable.setOnAction(event->{
            System.out.println("Variable");
        });
        //Lable
        Label lbSeparador4=new Label("");
        lbSeparador1.setId("lbSeparador");
        lbSeparador2.setId("lbSeparador");
        lbSeparador3.setId("lbSeparador");
        lbSeparador4.setId("lbSeparador");
        //VBox izquierda
        hBoxFiguras1.getChildren().addAll(btnCirculo,btnCuadrilatero);
        hBoxFiguras2.getChildren().addAll(btnIrregular,btnFxy);
        hBoxFiguras3.getChildren().addAll(btnAncla,btnCota);
        hBoxFiguras4.getChildren().addAll(btnBarra,btnBarraMoldeable);
        hBoxFiguras5.getChildren().addAll(btnUnion,btnSoldar);
        hBoxFiguras6.getChildren().addAll(btnResorte,btnAmortiguador);
        hBoxFiguras7.getChildren().addAll(btnCable,btnPolea);
        hBoxFiguras8.getChildren().addAll(btnMotor);
        hBoxFiguras9.getChildren().addAll(btnFuerza,btnMomento);
        hBoxFiguras10.getChildren().addAll(btnVelocidad,btnFuerzaVariable);
        vBoxPanel1.getChildren().addAll(hBoxFiguras1,hBoxFiguras2,lbSeparador1,hBoxFiguras3,
                hBoxFiguras4,hBoxFiguras5,lbSeparador2,hBoxFiguras6,hBoxFiguras7,hBoxFiguras8,
                lbSeparador3,hBoxFiguras9,hBoxFiguras10,lbSeparador4);
        //Panel 3
        Label tituloPanel3=new Label("Panel de estado");
        vBoxPanel3.getChildren().addAll(tituloPanel3);
        
        //BorderPane config
        borderPane.setTop(vBoxMenu);
        borderPane.setLeft(vBoxPanel1);
        borderPane.setCenter(canvas);
        borderPane.setRight(vBoxPanel3);
        borderPane.setBottom(hBoxBottom);
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        double screenWidth = screenBounds.getWidth();
        double screenHeight = screenBounds.getHeight();
        Scene scene=new Scene(borderPane,screenWidth,screenHeight);
        scene.getStylesheets().add(getClass().getResource("/com/roboticadomestica/recursos/estilos.css").toExternalForm());
        Image icono = new Image(getClass().getClassLoader().getResourceAsStream("imagenes/icono.png"));
        primaryStage.setTitle("Mecánica 2D");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(icono);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
