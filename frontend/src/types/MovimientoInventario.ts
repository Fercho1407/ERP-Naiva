export interface RegistroEntrada {
    idInventarioAlmacen: number;
    cantidad: number;
    costoUnitario: number;
    autorizacion: string;
    observaciones: string;
}

export interface RegistroEntradaResponse {
    tipomovimiento: string;
    fechaMovimiento: string;
    observaciones: string;
}

export interface RegistroSalida {
    idProductoInventarioAlmacen: number;
    stockSalida: number;
    autorizacion: string;
    costoUnitarioVenta: number;
    observaciones: string;
}

export interface RegistroSalidaResponse {
    stockActualizado: number;
    precioVenta: number;
}

export interface RegistroTraspaso {
    idAlmacenOrigen: number;
    idAlmacenDestino: number;
    idProductoInventarioAlmacen: number;
    stockTraspaso: number;
    nuevaUbicacionInterna: string;
    autotizacion: string;
    costoTranslado: number;
}

export interface RegistroTraspasoResponse {
    stockActualAlmacenOrigen: number;
    stockActualAlmacenDestino: number;
}