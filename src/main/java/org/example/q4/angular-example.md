# A minha experiência com o angular:

  Já trabalhei com Angular em alguns projetos profissionais e pessoais, principalmente em sistemas internos como dashboards
  administrativos, formulários complexos e integrações com APIs REST.
  
  Em um dos projetos mais recentes, precisei criar uma tela genérica que carregasse dinamicamente componentes diferentes
  de benefício, dependendo do código selecionado pelo usuário. Nesse caso, usei ViewContainerRef junto com uma factory
  para instanciar dinamicamente os componentes filhos, como no exemplo abaixo:


```javascript
  @ViewChild('beneficios', { static: true, read: ViewContainerRef })
  beneficioViewContainerRef!: ViewContainerRef;
  
  ngOnInit(): void {
    const codBeneficio = sessionStorage.getItem('codBeneficio');
    if (codBeneficio) {
      this.loadBeneficioComponent(codBeneficio);
    } else {
      this.toast.warning({
        message: 'Não foi possível prosseguir com a solicitação'
      });
      this.router.navigateByUrl('/selecao');
    }
  }

  public loadBeneficioComponent(codBeneficio: string) {
    const beneficioGroupComponent = beneficiosComponentFactory[codBeneficio];
    createGroupComponent(this.beneficioViewContainerRef, beneficioGroupComponent);
}
```

