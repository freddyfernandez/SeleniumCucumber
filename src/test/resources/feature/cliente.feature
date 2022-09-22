Feature: Mantenimiento de cliente en la aplicación web
    Como usuario
    Quiero dar de alta, modificar y eliminar un cliente en la aplicación web

    Background:
        Given soy un usuario
        And ingreso a la aplicacion

    Scenario: Alta de cliente
        When damos de alta un cliente
        Then el alta es exitosa

    Scenario: Modificar cliente
        When modificamos un cliente
        Then la modificacion es exitosa

    Scenario: Eliminar cliente
        When eliminamos un cliente
        Then la eliminacion es exitosa