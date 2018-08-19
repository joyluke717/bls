$file = 'D:\Greek\Code\tischendorf-data\word-per-line\2.7\Unicode\MT.txt'
$p = Get-Content $file -encoding utf8
foreach ($line in $p) 
{
   $items = $line.Split(" ")
   $book = $items[0]
   $verse= $items[1]
   $para_mark = $items[2]
   $text = $items[3]
   $word = $items[4]
   $ = $items[5]
   $book = $items[6]

}
