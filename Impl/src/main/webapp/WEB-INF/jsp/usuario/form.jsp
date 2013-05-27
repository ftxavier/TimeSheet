<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<label>Login</label>
<input type="text" name="usuario.login" value="${usuario.login}" class="input-xxlarge" placeholder="Login" />
<label>E-Mail</label>
<input type="text" name="usuario.email" value="${usuario.email}" class="input-xxlarge" placeholder="E-Mail"/>
<label>Nome</label>
<input type="text" name="usuario.nome" value="${usuario.name}"  class="input-xxlarge" placeholder="Nome"/>
<label>Roles</label>
<div class="controls controls-row">
	<select name="roles" multiple="multiple" size="8">
		<c:forEach items="${roles}" var="role">
			<option value="${role.id}">${role.name}</option>
		</c:forEach>
	</select>
	<input type="button" value="&lt;&lt;" id="removeAll" class="btn"/> 
	<input type="button" value="&lt;" id="remove" class="btn"/> 
	<input type="button" value="&gt;" id="add" class="btn"/> 
	<input type="button" value="&gt;&gt;" id="addAll" class="btn"/>
	<select name="usuario.roles" multiple="multiple" size="8">
		<c:forEach items="${usuario.roles}" var="role">
			<option value="${role.id}">${role.name}</option>
		</c:forEach>
	</select>
</div>
<input type="submit" class="btn btn-primary" value="Salvar" />