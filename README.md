# マークダウン設計レポーター

scalatestの結果をマークダウン形式で出力するレポーター

## 使い方

- 出力先：./design_doc

- このディレクトリごとtestディレクトリあたりに配置する

- build.sbtに以下を記述することで使える
  ```scala
  testOptions in Test ++= Seq(
    Tests.Argument(TestFrameworks.ScalaTest, "-C", "patera.MarkdownReporter")
  )
  ```

- テストファイル内で以下のように追記するとファイルの出力場所とファイル名を設定できる
  ```scala
  override def suiteName = "{ディレクトリ}/{ファイル名}"
  ```

## 出力例
-  出力内容
    - <font color="orange">未実装数: 1</font>, <font color="red">エラー数: 1</font>
    - 更新日 yyyy/mm/dd HH:ii:ss
    - 物理名 aaa.bbbb
    - markup
      ```scala
      説明コードなど
      ```
    - テストケース1
        - <font color="lightcyan">■</font> これは成功
    - テストケース2
        - <font color="orange">■</font> これはペンディング<font color="orange">(未実装)</font>
        - <font color="red">■</font> これは失敗<font color="red">(エラー)</font>
            - <font color="red">エラー内容~~~~~</font>
