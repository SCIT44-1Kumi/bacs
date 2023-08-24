const CreateMenuForm = () => {
	const onSubmit = () => {

	}
	return <div>
		<form action="" method="post">
			<input type="text" name={`menuName`} />
			<input type="text" name={`menuPrice`}/>
			<input type="submit" value="저장" />
		</form>
	</div>
}

export default CreateMenuForm;