import { ComponentFactoryResolver, Injectable, Renderer2, ViewContainerRef } from '@angular/core';
import { ErrorComponent } from '../components/error/error.component';

@Injectable()
export class ErrorService {
  private rootViewContainer!: ViewContainerRef;

  constructor(private resolver: ComponentFactoryResolver, private renderer: Renderer2) { }

  setRootViewContainerRef(viewContainerRef: ViewContainerRef) {
    this.rootViewContainer = viewContainerRef;
  }

  addError(message: string){
    const factory = this.resolver
                        .resolveComponentFactory(ErrorComponent);
    const component = factory.create(this.rootViewContainer.injector);
    component.instance.message = message;
    this.rootViewContainer.insert(component.hostView);
  }
}
