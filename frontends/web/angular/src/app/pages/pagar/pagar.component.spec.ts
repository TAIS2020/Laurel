import { TestBed, inject } from '@angular/core/testing';

import { PagarComponent } from './pagar.component';

describe('a pagar component', () => {
	let component: PagarComponent;

	// register all needed dependencies
	beforeEach(() => {
		TestBed.configureTestingModule({
			providers: [
				PagarComponent
			]
		});
	});

	// instantiation through framework injection
	beforeEach(inject([PagarComponent], (PagarComponent) => {
		component = PagarComponent;
	}));

	it('should have an instance', () => {
		expect(component).toBeDefined();
	});
});