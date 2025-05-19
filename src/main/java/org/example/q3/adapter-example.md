# Como eu uso um padrão de projeto para desacoplar código de uma biblioteca externa?

### Explicação:

Padrão utilizado: Adapter. Vamos supor que necessito utilizar uma biblioteca que gera relatorios em PDF, porém não
quero utilizar a biblioteca diretamente no código da aplicação, pois isso tornaria o código acoplado a biblioteca.
A ideia é criar uma interface que define o contrato de geração de relatórios e criar uma classe que implementa essa
interface, utilizando a biblioteca. A classe que vai implementar é o adapter, ou seja, a biblioteca nao vai estar
solto no código e sim dependendo de quem implementar a interface.

Exemplos:

```java
public interface pdfGenerator {
    void createPdf(String pages, String title, String body);
}

public class PdfGeneratorAdapter implements pdfGenerator {
    private final PdfLibrary pdfLibrary;

    public PdfGeneratorAdapter(PdfLibrary pdfLibrary) {
        this.pdfLibrary = pdfLibrary;
    }

    @Override
    public void createPdf(String pages, String title, String body) {
        pdfLibrary.createPdf(pages, title, body);
    }
}
```
Quando for utilizar, será necessário instanciar a interface. Para casos de outras implementações, pode utilizar
outro design pattern, como o strategy para definir qual implementação utilizar.

### Desvantagens:

    Caso a biblioteca nunca mude, não há necessidade de criar o adapter, pois o código vai ficar mais complexo. Precisa
    avaliar se vale a pena criar o adapter ou não.

