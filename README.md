Key changes I have been making:

**1. Extracting large class into smaller class**

    package frogger
    public class BackgroundAdd {
	
	BackgroundImage froggerbackground = new BackgroundImage("file:src/frogger/view/froggerbackground.png");
	static MyStage background = new MyStage();
	
	/**
	 * backgroundAdd constructor controls Frogger's background scene.
	 * @param background represents the objects shown on Frogger's game page
	 * In the main page, it includes log, turtle, wet turtle and obstacles.
	 * The background argument specifies the images being presented in the world
	 */
	public BackgroundAdd(MyStage background)
	{
		background.add(froggerbackground);
		
		background.add(new Log("file:src/frogger/view/log3.png", 150, 0, 166, 0.75));
		background.add(new Log("file:src/frogger/view/log3.png", 150, 220, 166, 0.75));
		background.add(new Log("file:src/frogger/view/log3.png", 150, 440, 166, 0.75));
		//background.add(new Log("file:src/frogger/view/log3.png", 150, 0, 166, 0.75));
		background.add(new Log("file:src/frogger/view/logs.png", 300, 0, 276, -2));
		background.add(new Log("file:src/frogger/view/logs.png", 300, 400, 276, -2));
		//background.add(new Log("file:src/frogger/view/logs.png", 300, 800, 276, -2));
		background.add(new Log("file:src/frogger/view/log3.png", 150, 50, 329, 0.75));
		background.add(new Log("file:src/frogger/view/log3.png", 150, 270, 329, 0.75));
		background.add(new Log("file:src/frogger/view/log3.png", 150, 490, 329, 0.75));
	//background.add(new Log("file:src/frogger/view/log3.png", 150, 570, 329, 0.75));


For example, I extracted adding background image originally from Main class into a separate class, which is named as BackgroundAdd class. In this class, programmers are easier to manipulate various objects being displayed in the world.
In other words, if the programmers are going to inspect the long process of both testing and debugging graphical user interface issue after Frogger is finished and would like to skip the game process, they can make annotations on the unnecessary objects shown in the world in order to accelerate their debugging process.
Hence, this change not only strengthens encapsulation, but also boosts both codes' maintainability and readability, because what this class does is to manipulate the images of objects being displayed in the world by making annotations, simple but effective, to a relative degree.

**2. Adding parameter object & Renaming**

	/**
	 * getScore method passes Animal class to retrieve its score
	 * @param animal used to receive score point
	 */
	public void getScore(Animal animal)
	{
		this.score = animal.getPoints();
	}
	
		/**
	 * getPlayerName class is used to receive player name from scoreBoardController class
	 * @param player means passing player name from scoreBoardController class
	 */
	public void getPlayerName(ScoreBoardController player)
	{
		this.playerName = player.setPlayerName();
	}
	 

In this way, I am not changing the parameter's value but simply passes it into both getScore and getPlayerName methods in ScoreBoardScene class. In this change, both getScore and getPlayerName can inherit both function of Animal and ScoreBoardController class, respectively. This not only saves effort in invoking methods from different class wrongly, but also achieving the merit of single responsibility and maintainability by specifically passing parameter into the designated constructor.

Besides adding parameter object, the other activity I conducted is renaming variables and its intention is to clarify the understanding of functionality of the code itself. For example,

	/**
	 * Obstacle constructor is used to set up obstacles shown in the world
	 * @param imageLink is used as linking the images of obstacles
	 * @param xpos explains obstacles' x coordinates
	 * @param ypos means obstacles' y coordinates
	 * @param Speed represents the speed of obstacle moving during Frogger game
	 * @param width defines the width of obstacle
	 * @param height determines the height of obstacle
	 */
	public Obstacle(String imageLink, int xPosition, int yPosition, int Speed, int width, int height) {
		
		setImage(new Image(imageLink, width,height, true, true));
		setX(xpos);
		setY(ypos);
		speed = Speed;
		
In Obstacle class, the original name of parameters in Obstacle constructor are vague and lack of full comprehension. Originally, w means width, h represents height, s is speed, x is x coordinate and so is y. If the code was not changed after renaming all the parameters, the code hardly interpret any meaningful instructions for other programmers to comprehend, until the variables' name is changed. It is believed that after this change, the reader could easily recognize what each parameter does for Obstacle constructor due to an increase in codes' readability.

**3. Applying Pull up Constructor Body method & extracting superclass**

In both BackgroundAdd and ScoreImageButton class, I assume a superclass constructor is MyStage and Animal class, respectively. 

BackgroundAdd class:

	public BackgroundAdd(MyStage background)
	{
		background.add(froggerbackground);
		
ScoreImageButton class:
		
	public ScoreImageButton(Animal animal){
		this.score = animal.getPoints();
	}

Although making this change is restricted in doing what superclass constructor does for the class. However, according to my intention, the only function I need to implement is to retrieve the value of getPoints method in Animal class. In addition, in terms of BackgroundAdd class, I did not attempt to change any functionality of methods in MyStage class, but simply manipulate background parameters in order to decide what images of obstacles will be displayed in the world. Therefore, by using pull up constructor body, it is easier to obtain the expected values from both classes without altering original functionality. Furthermore, this change helps reduce duplicate code in repetitive classes and avoids code overlapping issue.

**4. Replacing exception with tests**

By throwing a checked exception, the caller could have examine the error codes first.

	try {
			AnchorPane playerGUI = (AnchorPane)FXMLLoader.load(getClass().getResource("view/scoreBoard.fxml"));
			Scene scene = new Scene(playerGUI, 500, 300);
			primaryStage.setTitle("Frogger HiScore Board");
	
			primaryStage.setScene(scene);
			primaryStage.show();
		
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
				try (BufferedReader br = new BufferedReader(new FileReader("score.txt")))
		{
			String iCurrentLine;
			
			while((iCurrentLine = br.readLine()) != null) {
				playerScore.add(iCurrentLine);
				
				// print out the score result on scoreBoard scene
				System.out.println("Player's score: " + iCurrentLine);
			}
		} catch (IOException e)
		{
			e.printStackTrace();
			
		}
	
For instance, in ScoreImageButton class, replacing exception with tests is easier to spot where the error codes occur. As I was using BufferedReader to read a text file and attempted to retrieve its first line value, however, the code did fail and caused InvocationTargetException and FileNotFoundException issues before. Thanks to printStackTrace function in IOException class, I was able to quickly sort out the problem I had, such as adding extra level of abstraction by calling the method with reflection and writing wrong address of retrieving score text file.
Although this change may not fully replace the importance of regression testing, it still brings a significant advantage of discovering code error earlier and points out which exact line causes specific problems. Overall, this change helps save time for resolving where the code error would possibly be as well as boosting code's maintainability. 