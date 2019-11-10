package com.wallet.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserWalletDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotNull(message = "Informe o id do usuário")
	private Long users;
	@NotNull(message = "Informa o id da carteira")
	private Long wallet;
}
