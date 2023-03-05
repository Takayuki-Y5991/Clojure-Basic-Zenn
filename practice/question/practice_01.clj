; 1. 整数xを引数として受け取り、xの2乗を計算して返す関数を定義してください。
(defn function01 [x]
  (* x x))

; 2. リストを引数として受け取り、そのリストの要素を1つずつ表示する関数を定義してください。
(defn function02 [list]
  (if (empty? list)
    nil
    (do ((println (first list))
         (function02 (rest list))))))

(defn function02 [list]
  (doseq [e list]
    (println e)))

; 3. 整数nを引数として受け取り、1からnまでの整数を表示する関数を定義してください。
(defn function03 [x & args]
  (doseq [e (range 1 (inc x))]
         (println e)))

(defn function03 [x & args]
  (assert (integer? x) "x must be an integer")
  (doseq [e (range 1 (inc x))]
         (println e)))
;; assertマクロの第1引数には、検査対象の条件式を指定します。
;; ここでは、integer?関数を使って、引数xが整数型であるかどうかを検査しています。
;; もしxが整数型でない場合、第2引数に指定したエラーメッセージが表示され、実行が中断されます。


; 4. 2つの整数xとyを引数として受け取り、xとyの平均値を計算して返す関数を定義してください。
(defn function04 [lst target]
  (let [idx (binary-search lst target)]
    (if (neg? idx)
      (println "Target value not found in the list.")
      (println (str "Target value found at index " idx " in the list.")))))
;; 拡張版
(defn avg [& args]
  (/ (apply + args) (count args)))

; 5. 文字列を引数として受け取り、その文字列が回文であるかどうかを判定する関数を定義してください。
(defn function05 [x]
  (= (clojure.string/lower-case x)
     (clojure.string/lower-case (apply str (reverse x)))))

; キーと値のペアを持つマップを引数として受け取り、キーと値を入れ替えた新しいマップを返す関数を定義してください。
(defn function06 [map]
  (into {} (for [[k v] map] [v k])))

; 整数nを引数として受け取り、n番目のフィボナッチ数を計算して返す関数を定義してください。
(defn fibonacci [n]
  (if (< n 2)
    n
    (+ (fibonacci (- n 1))(fibonacci(- n 2)))))

; ベクターを引数として受け取り、ベクターの要素を2倍にした新しいベクターを返す関数を定義してください。
(defn function08 [x]
  (vec (map #(* 2 %) x)))

(defn function08 [x]
  (-> x 
      (map #(* 2 %))
      vec))

; 文字列とパターンを引数として受け取り、パターンに一致する最初の部分文字列を返す関数を定義してください。
(defn function09 [x pattern]
  (re-find (re-pattern pattern) x))

; add 関数を拡張し、3つ以上の引数を受け取り、それらの合計を返すようにしてください。
(defn add [& args]
  (reduce + args)
  )

; 以下のリスト [1 2 3 4 5] を反転して、[5 4 3 2 1] となるようにしてください。ただし、組み込みの reverse 関数は使用しないでください。
(defn my-reverse [lst]
  (if (empty? lst)
    lst
    (concat (my-reverse (rest lst)) (list (first lst)))))

; 整数値を引数として取り、その数が偶数である場合は "even" を、奇数である場合は "odd" を返す関数 even-or-odd を作成してください。
(defn even-or-odd [target]
  (if (= (　mod target 2) 0)
    "even"
    "odd"
    )
  )

; 以下のように、defn を使用して無名関数を作成してください。この関数は、引数として渡されたリスト内の要素をすべて二乗し、新しいリストを返します
; (square-all '(1 2 3 4 5)) ; => (1 4 9 16 25)
(fn [lst] (map #(* % %) lst))

