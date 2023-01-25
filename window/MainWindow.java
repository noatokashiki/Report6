package window;

import enums.Hands;
import enums.Status;

import javax.swing.*;


public class MainWindow{
    private final JFrame frame;

    private final JLabel messageLabel;
    
    private final JButton OneButton;

    private final JButton TwoButton;

    private final JButton ThreeButton;

    private final JButton FourButton;

    private final JButton FiveButton;

    private final JButton SixButton;

    private final JButton SevenButton;

    private final JButton EightButton;

    private final JButton NineButton;

    private final JButton TenButton;

    private Status playState;

    private Hands opponentHand;

    public MainWindow() {
        // 画面生成
        this.frame = new JFrame("下克上ゲーム");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 画面サイズを指定
        this.frame.setBounds(200, 200, 800, 400);
    
        var pane = this.frame.getContentPane();
    
        // このcanvasに対して、ボタンやラベルを配置していく
        var canvas = new JPanel();
        // 自由レイアウトに変更する
        canvas.setLayout(null);
    
        // ラベル
        this.messageLabel = new JLabel("これから下克上ゲームを開始します");
        this.messageLabel.setBounds(20, 20, 400, 30);
        canvas.add(this.messageLabel);
    
        // --------------
        // ボタンを作成する
        // --------------
    
        // 1
        this.OneButton = new JButton(Hands.One.getDisplay());
        this.OneButton.setBounds(100, 100, 100, 40);
        this.OneButton.addActionListener((e) -> this.selectHand(Hands.One));
        canvas.add(this.OneButton);
    
        // 2
        this.TwoButton = new JButton(Hands.Two.getDisplay());
        TwoButton.setBounds(250, 100, 100, 40);
        this.TwoButton.addActionListener((e) -> this.selectHand(Hands.Two));
        canvas.add(TwoButton);
    
        // 3
        this.ThreeButton = new JButton(Hands.Three.getDisplay());
        ThreeButton.setBounds(400, 100, 100, 40);
        this.ThreeButton.addActionListener((e) -> this.selectHand(Hands.Three));
        canvas.add(ThreeButton);

        //4
        this.FourButton = new JButton(Hands.Four.getDisplay());
        FourButton.setBounds(100, 200, 100, 40);
        this.FourButton.addActionListener((e) -> this.selectHand(Hands.Four));
        canvas.add(FourButton);

        //5
        this.FiveButton = new JButton(Hands.Five.getDisplay());
        FiveButton.setBounds(250, 200, 100, 40);
        this.FiveButton.addActionListener((e) -> this.selectHand(Hands.Five));
        canvas.add(FiveButton);

        //6
        this.SixButton = new JButton(Hands.Six.getDisplay());
        SixButton.setBounds(400, 200, 100, 40);
        this.SixButton.addActionListener((e) -> this.selectHand(Hands.Six));
        canvas.add(SixButton);

        //7
        this.SevenButton = new JButton(Hands.Seven.getDisplay());
        SevenButton.setBounds(100, 300, 100, 40);
        this.SevenButton.addActionListener((e) -> this.selectHand(Hands.Seven));
        canvas.add(SevenButton);

        //8
        this.EightButton = new JButton(Hands.Eight.getDisplay());
        EightButton.setBounds(250, 300, 100, 40);
        this.EightButton.addActionListener((e) -> this.selectHand(Hands.Eight));
        canvas.add(EightButton);

        //9
        this.NineButton = new JButton(Hands.Nine.getDisplay());
        NineButton.setBounds(400, 300, 100, 40);
        this.NineButton.addActionListener((e) -> this.selectHand(Hands.Nine));
        canvas.add(NineButton);

        //10
        this.TenButton = new JButton(Hands.Ten.getDisplay());
        TenButton.setBounds(550, 300, 100, 40);
        this.TenButton.addActionListener((e) -> this.selectHand(Hands.Ten));
        canvas.add(TenButton);
    
        // 画面にCanvasを追加
        pane.add(canvas);
      }
    
      /**
       * 画面表示
       */
      public void show() {
        this.init();
        this.frame.setVisible(true);
      }
    
      /**
       * ゲームの初期化
       */
      public void init() {
        // 相手の手をリセットし、待ち状態にする
        this.opponentHand = Hands.getRandomHand();
        this.playState = Status.Wait;
      }
    
      /**
       * 自分の手を選んだ時の処理
       *
       * @param selected 選択した手
       */
      public void selectHand(Hands selected) {
    
        // 入力待ちでなければ以降の処理はしない
        if (this.playState != Status.Wait) {
          return;
        }

        if (selected.getNumber() == opponentHand.getNumber()){
          this.messageLabel.setText("引き分けです。もう一度"); 
          this.init();

        } else if (selected.getNumber() > opponentHand.getNumber()){
          this.messageLabel.setText(String.format("相手が出したのは「%s」なのであなたの勝ちです。", this.opponentHand.getDisplay()));
          this.playState = Status.Done; 

        } else if (selected.getNumber() < opponentHand.getNumber()){
          this.messageLabel.setText(String.format("相手が出したのは「%s」なのであなたの負けです。", this.opponentHand.getDisplay()));
          this.playState = Status.Done; 
        }
  
      }
    
}



