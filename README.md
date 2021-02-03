PDF Merger
===========================

经常会遇到合并PDF的要求，尽管网上可以搜索到很多，但是绝大部分是收费的，免费的只能合并很少的PDF文件数量，而且输出不带标签。
所以写了一个合并PDF的小工具，如果源PDF没有标签，则会自动创建一个以文件名为标签名的标签，如果源PDF存在标签，则直接使用源PDF的标签。

### How to use

```
java -jar pdf-merger.jar <input-folder> <output-pdf>
```

例如:

```
java -jar pdf-merger.jar E:/知识图谱精选论文集/关系抽取/  D:/关系抽取.pdf
```