<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<label>Data</label>
<input type="text" name="data" value="<fmt:formatDate value="${registro.entrada.time}" pattern="dd/MM/yyyy" />" class="input-xxlarge dataMask" placeholder="Data" />
<label>Entrada</label>
<input type="text" name="entrada" value="<fmt:formatDate value="${registro.entrada.time}" pattern="HH:mm:ss" />" class="input-xxlarge horaMask" placeholder="Hora"/>
<label>Sa&iacute;da</label>
<input type="text" name="saida" value="<fmt:formatDate value="${registro.saida.time}" pattern="HH:mm:ss" />" class="input-xxlarge horaMask" placeholder="Hora"/>
<hr/>
<input type="submit" class="btn btn-primary" value="Salvar" />